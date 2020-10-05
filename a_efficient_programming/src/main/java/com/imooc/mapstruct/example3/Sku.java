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
public class Sku {

    private Long id;

    private String code;

    private Integer price;
}
