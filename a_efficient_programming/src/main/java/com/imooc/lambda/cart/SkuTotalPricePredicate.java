package com.imooc.lambda.cart;

import java.util.function.Predicate;

/**
 * 对Sku的总价是否超出2000作为判断标准
 *
 * @author zhaobin11@baidu.com
 */
public class SkuTotalPricePredicate implements Predicate<Sku> {

    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}
