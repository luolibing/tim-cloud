package cn.tim.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by TIM on 2017/3/5.
 * Eureka服务注册
 * 1 服务注册到Eureka Server中， 然后会通过心跳来保持服务注册， 当心跳间隔超过了最大时间， 会认为连接中断服务被注销。
 * 2 Eureka会将注册表复制给Eureka客户端， 这样客户端就不需要每次请求都通过注册中心了。
 * 3 Eureka Server同样是client， 需要制定Server的位置。
 * 4 多Eureka Server， 可以提供更好的弹性和可用性， 批次的Server需要相互注册
 * 4 Eureka client需要开启健康检查才能及时刷新状态， 不然会被认为是一直处于UP
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
