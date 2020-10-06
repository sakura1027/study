package com.imooc.lombok;


import lombok.NonNull;

/**
 * @author zhaobin11@baidu.com
 */
public class NonNullTest {

    public NonNullTest(@NonNull String field) {
        System.out.println(field);
    }
}
