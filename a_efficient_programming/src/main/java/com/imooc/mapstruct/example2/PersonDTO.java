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
public class PersonDTO {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Date birth;

    private String birthDateFormat;

    private String birthExpressionFormat;
}
