package cn.boxfish.cloud.feigh;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by LuoLiBing on 17/3/8.
 */
@Data
public class Person implements Serializable {
    private static long count = 0;
    private long id = count++;
    private String name;
}
