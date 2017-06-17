package cn.boxfish.cloud.zuul.filter;

/**
 * Created by LuoLiBing on 17/3/16.
 * Zuul的http client默认使用Apache HTTP Client而不是过时的RestClient
 * 如果需要使用RestClient或者使用OkHttpClient配置 ribbon.restclient.enabled=true或者是ribbon.okhttp.enabled=true
 */
public class ZuulClient {
}
