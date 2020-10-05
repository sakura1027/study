package com.imooc.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不可变集合用法
 *
 * @author zhaobin11@baidu.com
 */
public class ImmutableTest {

    public static void test(List<Integer> list) {
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> newList = Collections.unmodifiableList(list);

        test(newList);
        System.out.println(newList);
    }

    public void immutable() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // 方式1
        ImmutableSet.copyOf(list);

        // 方式2
        ImmutableSet.of(1, 2, 3);

        // 方式3
        ImmutableSet.builder()
                .add(1)
                .addAll(Sets.newHashSet(2, 3))
                .add(4)
                .build();
    }
}
