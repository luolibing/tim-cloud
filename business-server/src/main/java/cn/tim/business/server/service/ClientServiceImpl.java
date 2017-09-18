package cn.tim.business.server.service;

import cn.tim.feign.interfaces.eurekaclient.EurekaClient;
import cn.tim.feign.interfaces.eurekaclient.entity.Person;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * User: luolibing
 * Date: 2017/9/18 17:10
 */
@RestController
public class ClientServiceImpl implements EurekaClient {
    @Override
    public Object discoveryClient() {
        return null;
    }

    @Override
    public Object eurekaClient() {
        return null;
    }

    @Override
    public Person person(Long id) {
        Person person = new Person();
        person.setId(id);
        person.setName(UUID.randomUUID().toString());
        return person;
    }

    @Override
    public Person person(String name) {
        return null;
    }

    @Override
    public Person person(Long id, Person person) {
        return null;
    }
}
