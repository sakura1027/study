package com.imooc.lombok;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @author zhaobin11@baidu.com
 */
public class GetterTest {

    @Getter(
            value = AccessLevel.PRIVATE,
            onMethod_ = {@NotNull}
    )
    private String field1;

    @Getter(
            lazy = true
    )
    private final String field2 = "sakura";
}
