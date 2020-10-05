package com.imooc.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的构建形式
 *
 * @author zhaobin11@baidu.com
 */
public class StreamConstructor {

    @Test
    public void streamFromValue() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromFile() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("C:\\study\\a_efficient_programming\\src\\test\\java\\com\\imooc\\stream\\StreamConstructor.java"));
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromFunction() {
//        Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        Stream<Double> stream = Stream.generate(Math::random);
        stream.limit(100).forEach(System.out::println);
    }
}
