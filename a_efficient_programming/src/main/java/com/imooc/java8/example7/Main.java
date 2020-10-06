package com.imooc.java8.example7;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author zhaobin11@baidu.com
 */
public class Main {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("huge", 18),
                new Person("liuyifei", 19), new Person("wangyuyan", 20));
        getPersonByName("huge", personList).forEach(System.out::println); // Person(name=huge, age=18)
        getPersonByAge(19, personList).forEach(System.out::println); // Person(name=wangyuyan, age=20)
        getPersonByAge2(19, personList, (age, persons) -> persons.stream()
                .filter(one -> one.getAge() > age).collect(Collectors.toList()))
                .forEach(System.out::println); // Person(name=wangyuyan, age=20)
    }

    public static List<Person> getPersonByName(String name, List<Person> personList) {
        return personList.stream().filter(one -> one.getName().equals(name)).collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge(int age, List<Person> personList) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (k, persons) ->
                persons.stream().filter(one -> one.getAge() > k).collect(Collectors.toList());
        return biFunction.apply(age, personList);
    }

    // 行为传递更加灵活
    public static List<Person> getPersonByAge2(int age, List<Person> personList,
                                               BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, personList);
    }
}
