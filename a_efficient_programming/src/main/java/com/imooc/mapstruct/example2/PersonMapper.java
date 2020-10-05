package com.imooc.mapstruct.example2;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author zhaobin.11@bytedance.com
 */
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target = "email", ignore = true),
            @Mapping(source = "birthday", target = "birth"),
            @Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
            @Mapping(source = "user.age", target = "age")
    })
    PersonDTO domain2dto(Person person);

    List<PersonDTO> domain2dto(List<Person> people);

    @InheritConfiguration(name = "domain2dto")
    void update(Person person, @MappingTarget PersonDTO personDTO);
}
