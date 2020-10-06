package com.imooc.java8.example2;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhaobin11@baidu.com
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(one -> System.out.println(one));
        System.out.println("----");
        list.forEach(System.out::println); // method reference
    }
}
