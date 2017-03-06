package cn.boxfish.cloud.eureka.client;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by TIM on 2017/3/5.
 * 默认的心跳周期为30秒
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    /**
     * EurekaClient所有的服务域
     */
    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping(value = "/eureka/client")
    public Object eurekaClient() {
        System.out.println("Regions: ");
        eurekaClient.getAllKnownRegions().forEach(System.out::print);
        Applications apps = eurekaClient.getApplications();
        for(Application app: apps.getRegisteredApplications()) {
            System.out.println(app);
        }
        return eurekaClient;
    }

    /**
     * 服务发现的所有服务列表
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/eureka/discovery")
    public Object discoveryClient() {
        List<String> services = discoveryClient.getServices();
        for(String serviceId : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            if(!CollectionUtils.isEmpty(instances)) {
                for(ServiceInstance instance : instances) {
                    System.out.println(instance.getHost() + ":" + instance.getServiceId() + ": "
                            + instance.getPort() + ":" + instance.getMetadata() + ":" + instance.getUri());
                }
            }
        }
        return discoveryClient;
    }
}
