package com.imooc.mapstruct.example1;

import org.mapstruct.Mapper;

/**
 * @author zhaobin.11@bytedance.com
 */
@Mapper
public interface OrderMapper {

    OrderQueryDTO entity2QueryDTO(Order order);
}
