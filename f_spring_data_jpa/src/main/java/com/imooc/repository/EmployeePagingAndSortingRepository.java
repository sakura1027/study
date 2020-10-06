package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zhaobin11@baidu.com
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
