package com.imooc.repository;

import com.imooc.domain.Employee;
import com.imooc.utils.JsonUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author zhaobin11@baidu.com
 */
public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("-----setup-----");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("-----tearDown-----");
    }

    @Test
    public void testPage() {
        Pageable pageable = new PageRequest(1, 9);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println(JsonUtils.toPrettyString(page));

        System.out.println("是否第一页: " + page.isFirst());
        System.out.println("是否最后一页: " + page.isLast());
        System.out.println("是否排序: " + page.getSort());
        System.out.println("总页数: " + page.getTotalPages());
        System.out.println("总记录数: " + page.getTotalElements());
        System.out.println("page: " + page.getNumber());
        System.out.println("limit: " + page.getSize());
        System.out.println("当前页集合: " + page.getContent());
        System.out.println("当前页记录数: " + page.getNumberOfElements());
    }

    @Test
    public void testPageAndSort() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(1, 9, sort);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println(JsonUtils.toPrettyString(page));

        System.out.println("是否第一页: " + page.isFirst());
        System.out.println("是否最后一页: " + page.isLast());
        System.out.println("是否排序: " + page.getSort());
        System.out.println("总页数: " + page.getTotalPages());
        System.out.println("总记录数: " + page.getTotalElements());
        System.out.println("page: " + page.getNumber());
        System.out.println("limit: " + page.getSize());
        System.out.println("当前页集合: " + page.getContent());
        System.out.println("当前页记录数: " + page.getNumberOfElements());
    }
}
