package com.imooc.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author zhaobin11@baidu.com
 */
@RequiredArgsConstructor
public class ConstructorTest {

    private final String field1;

    @NonNull
    private String field2;

    private String field3;
}
