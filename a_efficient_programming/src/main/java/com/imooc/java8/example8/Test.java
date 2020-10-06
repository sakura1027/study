package com.imooc.java8.example8;

import java.util.function.Predicate;

/**
 * @author zhaobin11@baidu.com
 */
public class Test {

    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("hello")); // false
    }
}
