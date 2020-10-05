package com.imooc.mapstruct.example2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhaobin.11@bytedance.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long id;

    private String name;

    private String email;

    private Date birthday;

    private User user;
}
