package com.imooc.java8.example6;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author zhaobin11@baidu.com
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(fun(2, value -> value * 3, value -> value * value)); // 12
        System.out.println(fun2(2, value -> value * 3, value -> value * value)); // 36

        System.out.println(fun3(1, 2, (v1, v2) -> v1 + v2)); // 3
        System.out.println(fun4(2, 3, (v1, v2) -> v1 + v2, v -> v * v)); // 25
    }

    public static int fun(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return f1.compose(f2).apply(a);
    }

    public static int fun2(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return f1.andThen(f2).apply(a);
    }

    public static int fun3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public static int fun4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,
                           Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
