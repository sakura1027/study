package com.imooc.mapstruct.example3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaobin.11@bytedance.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkuDTO {

    private Long skuId;

    private String skuCode;

    private Integer skuPrice;

    private Long itemId;

    private String itemName;
}
