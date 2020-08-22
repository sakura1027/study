package com.imooc.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * spring data Entity类建议用Integer而不是int
 *
 * @author zhaobin11@baidu.com
 */
@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;
}
