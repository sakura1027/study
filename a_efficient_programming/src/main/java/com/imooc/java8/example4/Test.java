package com.imooc.java8.example4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaobin11@baidu.com
 */
public class Test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("google", "ali", "facebook");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });

        Collections.sort(names, Collections.reverseOrder());

        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
        System.out.println(names);
    }
}
