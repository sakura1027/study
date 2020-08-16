package com.imooc.lambda.cart;

import java.util.function.Predicate;

/**
 * 对Sku的商品类型为图书类的判断标准
 *
 * @author zhaobin11@baidu.com
 */
public class SkuBooksCategoryPredicate implements Predicate<Sku> {

    @Override
    public boolean test(Sku sku) {
        return sku.getSkuCategory() == SkuCategoryEnum.BOOKS;
    }
}
