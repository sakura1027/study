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
import java.util.Optional;

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
     * peek: 对流进行遍历操作，与forEach类似，但不会销毁流元素
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

    /**
     * 去重
     */
    @Test
    public void distinctTest() {
        skuList.stream()
                .map(Sku::getSkuCategory)
                .distinct()
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));

    }

    /**
     * 跳过
     */
    @Test
    public void skipTest() {
        skuList.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));
    }

    /**
     * 截断
     */
    @Test
    public void limitTest() {
        skuList.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(2 * 3) // 类似DB的分页操作
                .limit(3)
                .forEach(sku -> System.out.println(JsonUtils.toPrettyString(sku)));
    }

    /**
     * 终端操作，短路操作
     * 所有元素匹配返回true
     */
    @Test
    public void allMatchTest() {
        System.out.println(skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .allMatch(sku -> sku.getTotalPrice() > 100));
    }

    /**
     * 任何元素匹配返回true
     */
    @Test
    public void anyMatchTest() {
        System.out.println(skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 100));
    }

    /**
     * 任何元素都不匹配返回true
     */
    @Test
    public void noneMatchTest() {
        System.out.println(skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .noneMatch(sku -> sku.getTotalPrice() > 10_000));
    }

    @Test
    public void findFirstTest() {
        Optional<Sku> sku = skuList.stream()
                .findFirst();
        System.out.println(JsonUtils.toPrettyString(sku.orElse(null)));
    }

    @Test
    public void findAnyTest() {
        Optional<Sku> any = skuList.stream()
                .findAny();
        System.out.println(JsonUtils.toPrettyString(any.orElse(null)));
    }

    @Test
    public void maxTest() {
        System.out.println(skuList.stream()
                .mapToDouble(Sku::getTotalPrice)
                .max().orElse(0.0));
    }

    @Test
    public void minTest() {
        System.out.println(skuList.stream()
                .mapToDouble(Sku::getTotalPrice)
                .min().orElse(0.0));
    }

    @Test
    public void countTest() {
        System.out.println(skuList.stream()
                .skip(3)
                .count());
    }
}
