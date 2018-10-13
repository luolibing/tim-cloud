package cn.tim.cloud.hystrix.web;

public class ObjectHolder {

    public static final ThreadLocal<String> nameHolder;

    static {
        nameHolder = new ThreadLocal<>();
    }
}
