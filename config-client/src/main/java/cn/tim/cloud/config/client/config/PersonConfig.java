package cn.tim.cloud.config.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TIM on 2017/3/5.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "person")
public class PersonConfig {
    private String name;
    private Integer age;
}
