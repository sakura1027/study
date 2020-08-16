package com.imooc.stream;

import com.imooc.lambda.cart.CartService;
import com.imooc.lambda.cart.Sku;
import com.imooc.lambda.cart.SkuCategoryEnum;
import com.imooc.utils.JsonUtils;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 流与集合的区别
 * 集合面向存储
 * 流面向计算
 *
 * @author zhaobin11@baidu.com
 */
public class StreamVs {

    public void cartHandle() {
        AtomicReference<Double> money = new AtomicReference<>(0.0);

        List<String> skuResultList = CartService.cartSkuList.stream()
                .peek(sku -> System.out.println(JsonUtils.toPrettyString(sku))) // 打印商品信息
                .filter(sku -> sku.getSkuCategory() != SkuCategoryEnum.BOOKS) // 过滤掉所有图书类商品
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed()) // 排序
                .limit(2) // TOP2
                .peek(sku -> money.set(money.get() + sku.getTotalPrice())) // 累加商品总金额
                .map(Sku::getSkuName) // 获取商品名称
                .collect(Collectors.toList());// 收集结果信息
        System.out.println("--------------------");
        System.out.println(JsonUtils.toPrettyString(skuResultList));
        System.out.println("商品总价: " + money.get());
    }
}
