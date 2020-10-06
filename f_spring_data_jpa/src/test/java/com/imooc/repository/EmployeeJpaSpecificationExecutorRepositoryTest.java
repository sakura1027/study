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
import org.springframework.data.jpa.domain.Specification;

/**
 * @author zhaobin11@baidu.com
 */
public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("-----setup-----");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("-----tearDown-----");
    }

    /**
     * 分页 + 排序 + 查询条件
     */
    @Test
    public void testQuery() {
        Specification<Employee> specification = (root, query, cb) -> cb.gt(root.get("age"), 50);

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0, 9, sort);
        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification, pageable);
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
