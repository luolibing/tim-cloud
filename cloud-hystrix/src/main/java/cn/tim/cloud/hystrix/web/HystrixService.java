package cn.tim.cloud.hystrix.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

/**
 * Created by TIM on 2017/3/6.
 *
 */
@Service
public class HystrixService {

    private Random rand = new Random(47);

    /**
     * spring cloud自动封装了spring bean及注解在一个连接到断路器的代理当中.
     * 断路器负责计算何时打开或者关闭电路, 以及在故障的时候做什么
     * 因为@HystrixCommand这个地方用到了代理以及线程池, 所以如果想使用一些线程本地上下文传播到@HystrixCommand中, 默认是不会工作的.
     * 解决方法是切换Hystrix以使用与调用者相同的线程使用一些配置, 或者直接在注解中, 要求通过使用不同的隔离策略
     * @param params
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "defaultStores",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
            },
            // 线程池配置
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "5"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "2"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            }
    )
    @RequestMapping(value = "/hystrix/stores")
    public Object getStores(Map<String, Object> params) throws InterruptedException {
//        Thread.sleep(5000);
//        if(rand.nextInt(100) % 2 == 0) {
//            throw new RuntimeException("do stuff that might fail");
//        }
        System.out.println("threadId=" + Thread.currentThread().getId());
        System.out.println(ObjectHolder.nameHolder.get());
        return Collections.singletonMap("result", rand.nextInt(100));
    }


    /**
     * 可以通过配置hystrix.shareSecurityContext=true, 自动配置一个Hystrix并发策略插件挂钩, 将SecurityContext从主线程传递到Hystrix Command中使用
     * Hystrix不允许注册多个hystrix并发策略, 因此通过自己的HystrixConcurrencyStrategy声明为Spring Bean, 可以使用扩展机制.
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "defaultExecute1",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
            }
    )
    @RequestMapping(value = "/hystrix/execute1")
    public Object execute1() {
        return Collections.singletonMap("result", "execute1");
    }

    private Object defaultStores(Map<String, Object> parameters) {
        return Collections.singletonMap("result","defaultStore");
    }

    private Object defaultExecute1() {
        return Collections.singletonMap("result","defaultExecute1");
    }
}
