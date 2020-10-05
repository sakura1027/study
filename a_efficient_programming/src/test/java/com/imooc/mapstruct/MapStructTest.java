package com.imooc.mapstruct;

import com.google.common.collect.Lists;
import com.imooc.mapstruct.example1.Order;
import com.imooc.mapstruct.example1.OrderMapper;
import com.imooc.mapstruct.example1.OrderQueryDTO;
import com.imooc.mapstruct.example2.Person;
import com.imooc.mapstruct.example2.PersonDTO;
import com.imooc.mapstruct.example2.PersonMapper;
import com.imooc.mapstruct.example2.User;
import com.imooc.mapstruct.example3.Item;
import com.imooc.mapstruct.example3.ItemMapper;
import com.imooc.mapstruct.example3.Sku;
import com.imooc.mapstruct.example3.SkuDTO;
import com.imooc.utils.JsonUtils;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

/**
 * @author zhaobin.11@bytedance.com
 */
public class MapStructTest {

    @Test
    public void entity2queryParam() {
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setReceiverKeyword("keyword");
        order.setStatus(0);
        order.setOrderType(1);
        order.setSourceType(2);

        OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
        OrderQueryDTO dto = mapper.entity2QueryDTO(order);
        System.out.println(JsonUtils.toPrettyString(dto));
    }

    @Test
    public void personDomain2dto() {
        Person person = new Person(1L, "sakura", "zhaobin.11@bytedance.com", new Date(), new User(27));
        PersonDTO personDTO = PersonMapper.INSTANCE.domain2dto(person);
        System.out.println(JsonUtils.toPrettyString(personDTO));

        List<Person> people = Lists.newArrayList(person);
        List<PersonDTO> personDTOList = PersonMapper.INSTANCE.domain2dto(people);
        System.out.println(JsonUtils.toPrettyString(personDTOList));


        person.setName("lyf");
        PersonMapper.INSTANCE.update(person, personDTO);
        System.out.println(JsonUtils.toPrettyString(personDTO));
    }

    @Test
    public void itemDomain2dto() {
        Item item = new Item(1L, "iPhone X");
        Sku sku = new Sku(2L, "phone12345", 1000000);
        SkuDTO skuDTO = ItemMapper.INSTANCE.domain2dto(item, sku);
        System.out.println(JsonUtils.toPrettyString(skuDTO));
        System.out.println(ItemMapper.INSTANCE.convert2Bool(1));
    }
}
