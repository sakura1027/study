package com.imooc.guava;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zhaobin11@baidu.com
 */
public class OptionalTest {

    @Test
    public void test() {
        // 创建空的optional对象
        Optional.empty();

        // 非null值创建Optional对象
        Optional.of("sakura");

        // 任意值创建Optional对象
        Optional<String> optional = Optional.ofNullable("sakura");

        // 判断是否引用缺失（建议不用）
        System.out.println(optional.isPresent());

        optional.ifPresent(System.out::println);

        System.out.println(optional.orElse("引用缺失"));

        optional.orElseGet(() -> {
            return "自定义引用缺失";
        });

//        optional.orElseThrow(() -> {
//            throw new RuntimeException("");
//        });
    }

    public static void main(String[] args) {
        stream(null);
    }

    public static void stream(List<String> list) {
//        list.forEach(System.out::println);
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }
}
