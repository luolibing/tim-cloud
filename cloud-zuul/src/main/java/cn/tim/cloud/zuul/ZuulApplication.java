package cn.tim.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by LuoLiBing on 17/3/7.
 * 路由是微服务架构中很重要的一部分, Zuul是一个JVM语言基础路由与服务端负载均衡器
 * 是内嵌的一个反向代理, 很重要的一个作用是, 避免后端的所有服务都单独配置CORS和认证配置
 * 按照惯例, serviceId为users的服务, 将接受来自于/users前缀的请求
 * 不配置eureka client, 会默认链接到本机的localhost:8761/eureka
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
