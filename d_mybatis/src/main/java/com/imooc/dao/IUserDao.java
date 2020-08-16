package com.imooc.dao;

import com.imooc.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 * IUserDao也可以写成IUserMapper
 *
 * @author zhaobin11@baidu.com
 */
public interface IUserDao {

    List<User> findAll();

    /**
     * 可以移除掉IUserDao.xml
     */
    @Select("select * from user")
    List<User> findAllByAnnotation();
}
