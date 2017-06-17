package cn.tim.cloud.feigh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by LuoLiBing on 17/3/8.
 * Feign访问
 * Feign的一个核心概念是命名客户端, 每个feign客户端都是组件的一部分, 他们一起工作, 并且这个集合具有@FeignClient指定的名称.
 * spring cloud使用FeignClientsConfiguration组建一个新的ApplicationContext, 其中包括了Decoder, Encoder和Contract.
 * 用户可以通过@FeignClient额外声明一个在FeignClientsConfiguration之上的配置
 */
@SpringBootApplication
@EnableFeignClients // defaultConfiguration可以实现全局的Config
@EnableEurekaClient
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
