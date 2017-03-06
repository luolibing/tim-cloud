package cn.boxfish.cloud.hystrix.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

/**
 * Created by TIM on 2017/3/6.
 */
@RestController
public class HystrixController {

    private Random rand = new Random(47);

    @HystrixCommand(fallbackMethod = "defaultStores")
    @RequestMapping(value = "/hystrix/stores")
    public Object getStores(Map<String, Object> params) {
        if(rand.nextInt(100) % 2 == 0) {
            throw new RuntimeException("do stuff that might fail");
        }
        return Collections.singletonMap("result", rand.nextInt(100));
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return Collections.singletonMap("result","defaultStore");
    }
}
