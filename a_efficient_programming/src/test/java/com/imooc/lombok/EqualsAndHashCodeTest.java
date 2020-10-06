package com.imooc.lombok;

import lombok.EqualsAndHashCode;

/**
 * @author zhaobin11@baidu.com
 */
@EqualsAndHashCode(
        exclude = {"field1"}
)
public class EqualsAndHashCodeTest {

    private String field1;

    private String field2;
}
