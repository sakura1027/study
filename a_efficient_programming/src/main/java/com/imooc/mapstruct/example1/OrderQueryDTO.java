package com.imooc.mapstruct.example1;

import lombok.Data;

/**
 * @author zhaobin.11@bytedance.com
 */
@Data
public class OrderQueryDTO {

    private String orderSn;

    private String receiverKeyword;

    private Integer status;

    private Integer orderType;

    private Integer sourceType;
}
