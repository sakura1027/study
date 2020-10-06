package com.imooc.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaobin11@baidu.com
 */
@Data
public class Employee implements Serializable {

    private Integer id;

    private String name;

    private Integer age;
}
