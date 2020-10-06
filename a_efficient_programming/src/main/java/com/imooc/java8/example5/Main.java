package com.imooc.java8.example5;

import java.util.function.Function;

/**
 * @author zhaobin11@baidu.com
 */
public class Main {

    public static void main(String[] args) {
        // 传递行为而非值
        System.out.println(fun(1, value -> 2 * value));
        System.out.println(convert(1027, value -> "sakura" + value));
    }

    public static int fun(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public static String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }
}
