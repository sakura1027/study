package com.imooc.lombok;

import lombok.val;

import java.util.ArrayList;

/**
 * @author zhaobin11@baidu.com
 */
public class ValTest {

    public ValTest() {
        val field = "sakura";

        val list = new ArrayList<String>();
        list.add("sakura");
    }
}
