package com.imooc.lambda.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下单商品信息对象
 *
 * @author zhaobin11@baidu.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sku {

    // 编号
    private Integer skuId;

    // 商品名称
    private String skuName;

    // 单价
    private Double skuPrice;

    // 购买个数
    private Integer totalNum;

    // 总价
    private Double totalPrice;

    // 商品类型
    private SkuCategoryEnum skuCategory;
}
