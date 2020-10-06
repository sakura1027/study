package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhaobin11@baidu.com
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
