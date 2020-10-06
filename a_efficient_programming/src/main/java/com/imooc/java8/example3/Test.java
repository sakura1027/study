package com.imooc.java8.example3;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author zhaobin11@baidu.com
 */
public class Test {

    public static void main(String[] args) {
        Cat cat = () -> System.out.println("play");
        Dog dog = () -> System.out.println("eat");
        System.out.println(cat.getClass().getInterfaces()[0]);
        System.out.println(dog.getClass().getInterfaces()[0]);
        cat.play();
        dog.eat();

        Thread thread = new Thread(() -> System.out.println("hi"));
        thread.start();

        List<String> list = Arrays.asList("hello", "world");
        list.forEach(one -> System.out.println(one.toUpperCase()));

        List<String> res = Lists.newArrayList();
        list.forEach(one -> res.add(one.toUpperCase()));
        res.forEach(System.out::println);

        list.stream().map(one -> one.toLowerCase())
                .forEach(one -> System.out.println(one));

        list.stream().map(String::toUpperCase)
                .forEach(one -> System.out.println(one));

        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
    }
}
