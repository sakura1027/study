package com.imooc.stream;

import com.imooc.lambda.cart.CartService;
import com.imooc.lambda.cart.Sku;
import com.imooc.lambda.cart.SkuCategoryEnum;
import com.imooc.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 演示流的各种操作
 *
 * @author zhaobin11@baidu.com
 */
public class StreamOperator {

    private List<Sku> skuList;

    @Before
    public void init() {
        skuList = CartService.cartSkuList;
    }

    /**
     * 过滤掉不符合断言判断的数据
     */
    @Test
    public void filterTest() {
        skuList.stream()
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));
    }

    /**
     * 一个元素转换成另一个元素
     */
    @Test
    public void mapTest() {
        skuList.stream()
                .map(Sku::getSkuName)
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));
    }

    /**
     * 一个对象转换成流
     */
    @Test
    public void flatMapTest() {
        skuList.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));
    }

    /**
     * 交替执行
     */
    @Test
    public void peekTest() {
        skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));
    }

    @Test
    public void sortTest() {
        skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));
    }

    @Test
    public void distinctTest() {

    }
}
