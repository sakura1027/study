package com.imooc.lombok;

import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

/**
 * @author zhaobin11@baidu.com
 */
@ToString(
        includeFieldNames = false,
//        of = {"field1"},
        doNotUseGetters = true
)
public class ToStringTest {

    @Setter
    private String field1;

    @Setter
    private String field2;

    public String getField2() {
        System.out.println("调用get方法");
        return this.field2;
    }

    @Test
    public void test() {
        ToStringTest toStringTest = new ToStringTest();
        toStringTest.setField1("sakura");
        toStringTest.setField2("1027");
        System.out.println(toStringTest.toString());
    }
}
