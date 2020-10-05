package com.imooc.mapstruct.example3;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author zhaobin.11@bytedance.com
 */
@Mapper
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mappings({
            @Mapping(source = "sku.id", target = "skuId"),
            @Mapping(source = "sku.code", target = "skuCode"),
            @Mapping(source = "sku.price", target = "skuPrice"),
            @Mapping(source = "item.id", target = "itemId"),
            @Mapping(source = "item.title", target = "itemName")
    })
    SkuDTO domain2dto(Item item, Sku sku);

    default Boolean convert2Bool(Integer value) {
        return (value == null || value < 1) ? Boolean.FALSE : Boolean.TRUE;
    }
}
