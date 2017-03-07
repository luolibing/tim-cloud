package cn.boxfish.cloud.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TIM on 2017/3/7.
 */
@Configuration
public class EurekaClientConfig {

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }
}
