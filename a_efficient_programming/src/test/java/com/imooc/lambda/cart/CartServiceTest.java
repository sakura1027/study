package com.imooc.lambda.cart;

import com.imooc.utils.JsonUtils;
import org.junit.Test;

import java.util.List;


/**
 * @author zhaobin11@baidu.com
 */
public class CartServiceTest {

    @Test
    public void test1() {
        List<Sku> skuList = CartService.filterElectronicsSkuList(CartService.cartSkuList);
        System.out.println(JsonUtils.toPrettyString(skuList));
    }

    @Test
    public void test2() {
        List<Sku> skuList = CartService.filterSkuListByCategory(CartService.cartSkuList, SkuCategoryEnum.BOOKS);
        System.out.println(JsonUtils.toPrettyString(skuList));
    }

    @Test
    public void test3() {
        List<Sku> skuList = CartService.filterSkuList(CartService.cartSkuList, new SkuBooksCategoryPredicate());
        System.out.println(JsonUtils.toPrettyString(skuList));
    }

    @Test
    public void test4() {
        List<Sku> skuList = CartService.filterSkuList(CartService.cartSkuList, sku -> sku.getSkuCategory() == SkuCategoryEnum.BOOKS);
        System.out.println(JsonUtils.toPrettyString(skuList));
    }
}
