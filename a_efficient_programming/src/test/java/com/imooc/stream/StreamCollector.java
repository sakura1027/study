package com.imooc.stream;

import com.imooc.lambda.cart.CartService;
import com.imooc.lambda.cart.Sku;
import com.imooc.lambda.cart.SkuCategoryEnum;
import com.imooc.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 预定义收集器
 *
 * @author zhaobin11@baidu.com
 */
public class StreamCollector {

    private List<Sku> skuList;

    @Before
    public void init() {
        skuList = CartService.cartSkuList;
    }

    @Test
    public void toList() {
        List<Sku> res = skuList.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());
        System.out.println(JsonUtils.toPrettyString(res));
    }

    @Test
    public void group() {
        Map<SkuCategoryEnum, List<Sku>> collect = skuList.stream()
                .collect(Collectors.groupingBy(Sku::getSkuCategory));
        System.out.println(JsonUtils.toPrettyString(collect));
    }

    @Test
    public void partition() {
        Map<Boolean, List<Sku>> collect = skuList.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));
        System.out.println(JsonUtils.toPrettyString(collect));
    }
}
