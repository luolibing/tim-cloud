package cn.boxfish.cloud.config.client;

import cn.boxfish.cloud.config.client.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by TIM on 2017/3/5.
 */
@SpringBootApplication
public class ConfigClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Autowired
    private PersonConfig personConfig;

    @Value("${foo}")
    private String foo;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(personConfig);
        System.out.println(foo);
    }
}
