package com.imooc.dao;

import com.imooc.domain.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 * IEmployeeDao也可以写成IEmployeeMapper
 *
 * @author zhaobin11@baidu.com
 */
public interface IEmployeeDao {

    List<Employee> findAll();

    /**
     * 可以移除掉IUserDao.xml
     */
    @Select("select * from employee")
    List<Employee> findAllByAnnotation();
}
