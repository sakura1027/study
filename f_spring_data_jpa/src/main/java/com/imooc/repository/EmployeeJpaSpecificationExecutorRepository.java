package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhaobin11@baidu.com
 */
public interface EmployeeJpaSpecificationExecutorRepository
        extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

}
