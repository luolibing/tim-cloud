package cn.tim.cloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * Created by LuoLiBing on 17/3/7.
 * Ribbon是一个客户端负载均衡器, 提供了大量对http和tcp clients的控制.
 * Feign已经开始使用Ribbon
 * Ribbon的一个中心概念是命名客户端, 每个负载均衡器是组件的一部分, 他们一起工作以按需联系远程服务器, 并且整体作为应用开发者(@FeginClient)给出的名称.
 * 包含ILoadBalancer, RestClient和ServerListFilter
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

//    @Autowired
//    IClientConfig clientConfig;
//
//    @Autowired
//    IRule rule;
//
//    @Autowired
//    IPing iPing;
//
//    @Autowired
//    ServerList<Server> ribbonServerList;
//
//    @Autowired
//    ServerListFilter<Server> ribbonServerListFilter;
//
//    @Autowired
//    ILoadBalancer ribbonLoadBalancer;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/ribbon")
    public Object ribbon() {
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        URI uri = UriComponentsBuilder
                .fromUriString(String.format("http://%s:%s", instance.getHost(), Integer.toString(instance.getPort())))
                .path("/health")
                .build()
                .toUri();
        Map result = new RestTemplate().getForObject(uri, Map.class);
        System.out.println(result);
        return result;
    }
}