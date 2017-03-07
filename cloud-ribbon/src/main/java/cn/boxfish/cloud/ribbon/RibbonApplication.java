package cn.boxfish.cloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by LuoLiBing on 17/3/7.
 * Ribbon是一个客户端负载均衡器, 提供了大量对http和tcp clients的控制.
 * Feign已经开始使用Ribbon
 * Ribbon的一个中心概念是命名客户端, 每个负载均衡器是组件的一部分, 他们一起工作以按需联系远程服务器, 并且整体作为应用开发者(@FeginClient)给出的名称.
 * 包含ILoadBalancer, RestClient和ServerListFilter
 */
@SpringBootApplication
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}