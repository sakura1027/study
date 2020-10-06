package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaobin11@baidu.com
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
