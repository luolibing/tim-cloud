package cn.boxfish.cloud.feigh.config;

import cn.boxfish.feign.interfaces.eurekaclient.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Created by LuoLiBing on 17/3/8.
 * @ Import为导入配置, 类似于xml里面的import
 */
@Import(FeignClientsConfiguration.class)
public class PersonController {

    private EurekaClient eurekaClient;

    private EurekaClient adminClient;

    @Autowired
    public PersonController(

    ) {

    }
}
