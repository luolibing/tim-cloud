package cn.tim.cloud.eureka.client;

import cn.tim.cloud.eureka.client.entity.Person;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    public Map<String, String> eurekaClient() {
        System.out.println("Regions: ");
        eurekaClient.getAllKnownRegions().forEach(System.out::print);
        Applications apps = eurekaClient.getApplications();
        for(Application app: apps.getRegisteredApplications()) {
            System.out.println(app);
        }
        return Collections.singletonMap("result", "eureka/client");
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

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person person(@PathVariable Long id) {
        Person person = new Person();
        person.setId(id);
        person.setName("luolibing");
        return person;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Person person(String name) {
        Person person = new Person();
        person.setName(name);
        return person;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.POST)
    public Person person(@PathVariable Long id, Person person) {
        person.setName(person.getName() + "_save");
        return person;
    }
}
