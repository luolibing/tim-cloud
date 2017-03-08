package cn.boxfish.feign.interfaces.eurekaclient.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LuoLiBing on 17/3/8.
 * 自定义声明一个在FeignClientsConfiguration之上的配置
 */
@Configuration
public class PersonConfiguration {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    /**
     * 自定义
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

//    class TokenAuthRequestInterceptor implements RequestInterceptor {
//
//        @Override
//        public void apply(RequestTemplate template) {
//            template.request().get;
//        }
//    }
}
