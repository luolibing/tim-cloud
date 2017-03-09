package cn.boxfish.cloud.feigh.config;

/**
 * Created by LuoLiBing on 17/3/8.
 * @ Import为导入配置, 类似于xml里面的import
 */
//@Import(FeignClientsConfiguration.class)
//public class PersonController {
//
//    public final EurekaClient eurekaClient;
//
//    public final EurekaClient adminClient;
//
//    @Autowired
//    public PersonController(
//        ResponseEntityDecoder decoder, SpringEncoder encoder, Client client) {
//        this.eurekaClient = Feign.builder().client(client)
//                .encoder(encoder)
//                .decoder(decoder)
//                .requestInterceptor(new BasicAuthRequestInterceptor("user", "user"))
//                .target(EurekaClient.class, "http://localhost:8002");
//        this.adminClient = Feign.builder().client(client)
//                .encoder(encoder)
//                .decoder(decoder)
//                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin"))
//                .target(EurekaClient.class, "http://localhost:8002");
//    }
//}
