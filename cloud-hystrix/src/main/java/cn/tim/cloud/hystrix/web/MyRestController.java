package cn.tim.cloud.hystrix.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyRestController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping(value = "/hystrix/stores")
    public Object getStores(Map<String, Object> params) throws InterruptedException {
        ObjectHolder.nameHolder.set("luolibing");
        System.out.println("threadId=" + Thread.currentThread().getId());
        Object stores = hystrixService.getStores(params);
        System.out.println(stores);
        return stores;
    }
}
