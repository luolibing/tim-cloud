package cn.boxfish.cloud.feigh.web;

import cn.boxfish.feign.interfaces.eurekaclient.EurekaClient;
import cn.boxfish.feign.interfaces.eurekaclient.entity.Person;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuoLiBing on 17/3/8.
 */
@RestController
@RequestMapping(value = "/feign")
@Import(EurekaClient.class)
public class PersonController {

    private EurekaClient eurekaClient;

    @RequestMapping(value = "/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return eurekaClient.person(id);
    }
}
