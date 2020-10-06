package com.imooc.java8.example7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaobin11@baidu.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;

    private int age;
}
