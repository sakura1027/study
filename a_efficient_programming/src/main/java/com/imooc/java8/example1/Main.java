package com.imooc.java8.example1;

/**
 * @author zhaobin11@baidu.com
 */
public class Main {

    public static void fun(Animal animal) {
        System.out.println(1);
        animal.test(2);
        System.out.println(3);
    }

    public static void main(String[] args) {
        Animal animal = (a) -> System.out.println(a);
        Main.fun(animal);
        // 在java语言中，lambda表达式是对象而不是函数，必须依附于函数式接口而存在
        System.out.println(animal.getClass()); // class Main$$Lambda$1/990368553
        System.out.println(animal.getClass().getSuperclass()); // class java.lang.Object
        System.out.println(animal.getClass().getInterfaces()[0]); // interface Animal2
    }
}
