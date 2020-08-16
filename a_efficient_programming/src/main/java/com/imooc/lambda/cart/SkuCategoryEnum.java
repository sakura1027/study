package com.imooc.lambda.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 商品类型
 *
 * @author zhaobin11@baidu.com
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SkuCategoryEnum {
    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "数码产品类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类");

    // 商品类型编号
    private Integer code;

    // 商品类型名称
    private String name;
}
