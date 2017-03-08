package cn.boxfish.feign.interfaces.eurekaclient;

import cn.boxfish.feign.interfaces.eurekaclient.config.PersonConfiguration;
import cn.boxfish.feign.interfaces.eurekaclient.entity.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LuoLiBing on 17/3/8.
 * 自定义的Configuration可以选择性地覆盖掉FeignClientsConfiguration中的元素配置
 * 不能将FeignClientsConfiguration放到Application主引用程序上下文中, 否则会将其用到所有的@FeignClient中
 *
 * Spring Cloud Netflix为feign提供的Bean
 * Decoder, Encoder, Logger, Contract, Feign.Builder, Client
 */
//@FeignClient(name = "eureka-client", configuration = PersonConfiguration.class)
@FeignClient(name = "${feign.name}", url = "${feign.url}", configuration = PersonConfiguration.class)
public interface EurekaClient {
    @RequestMapping(value = "/eureka/discovery", method = RequestMethod.GET)
    Object discoveryClient();

    @RequestMapping(value = "/eureka/client")
    Object eurekaClient();

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    Person person(@PathVariable Long id);

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    Person person(String name);

    @RequestMapping(value = "/person/{id}", method = RequestMethod.POST)
    Person person(@PathVariable Long id, Person person);
}
