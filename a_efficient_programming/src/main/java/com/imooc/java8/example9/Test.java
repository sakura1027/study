package com.imooc.java8.example9;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhaobin11@baidu.com
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        conditionFilter(list, item -> item % 2 == 0);
        conditionFilter(list, item -> item % 2 != 0);
        conditionFilter(list, item -> item > 5);
        conditionFilter(list, item -> item < 3);
        conditionFilter(list, item -> true);
    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }
}
