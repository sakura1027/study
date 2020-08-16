package com.imooc.lambda.cart;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 购物车服务类
 *
 * @author zhaobin11@baidu.com
 */
@Data
public class CartService {

    // 加入到购物车中的商品信息
    public static List<Sku> cartSkuList = Lists.newArrayList(
            new Sku(654032, "无人机", 4999.00, 1, 4999.00, SkuCategoryEnum.ELECTRONICS),
            new Sku(642934, "VR一体机", 2299.00, 1, 2299.00, SkuCategoryEnum.ELECTRONICS),
            new Sku(645321, "纯色衬衫", 409.00, 3, 1227.00, SkuCategoryEnum.CLOTHING),
            new Sku(654327, "牛仔裤", 528.00, 1, 528.00, SkuCategoryEnum.CLOTHING),
            new Sku(675489, "跑步机", 2699.00, 1, 2699.00, SkuCategoryEnum.SPORTS),
            new Sku(644564, "Java编程思想", 79.80, 1, 79.80, SkuCategoryEnum.BOOKS),
            new Sku(678678, "Java核心技术", 149.00, 1, 149.00, SkuCategoryEnum.BOOKS),
            new Sku(697894, "算法", 78.20, 1, 78.20, SkuCategoryEnum.BOOKS),
            new Sku(696968, "TensorFlow进阶指南", 85.10, 1, 85.10, SkuCategoryEnum.BOOKS)
    );

    // tips: windows IDEA Ctrl + Y 删除单行
    public static List<Sku> filterElectronicsSkuList(List<Sku> cartSkuList) {
        return cartSkuList.stream()
                .filter(sku -> sku.getSkuCategory() == SkuCategoryEnum.ELECTRONICS)
                .collect(Collectors.toList());
    }

    public static List<Sku> filterSkuListByCategory(List<Sku> cartSkuList, SkuCategoryEnum category) {
        return cartSkuList.stream()
                .filter(sku -> sku.getSkuCategory() == category)
                .collect(Collectors.toList());
    }

    /**
     * 根据不同的Sku判断标准，对Sku列表进行过滤
     *
     * @param cartSkuList
     * @param predicate
     * @return
     */
    public static List<Sku> filterSkuList(List<Sku> cartSkuList, Predicate<Sku> predicate) {
        return cartSkuList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
