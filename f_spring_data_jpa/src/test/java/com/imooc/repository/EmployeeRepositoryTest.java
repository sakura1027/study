package com.imooc.repository;

import com.google.common.collect.Lists;
import com.imooc.utils.JsonUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaobin11@baidu.com
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("-----setup-----");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("-----tearDown-----");
    }

    @Test
    public void testEntityManagerFactory() {

    }

    @Test
    public void testFindByName() {
        System.out.println(employeeRepository.findByName("sakura"));
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.findByNameStartingWithAndAgeLessThan("test", 22)));
    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.findByNameEndingWithAndAgeLessThan("6", 23)));
    }

    @Test
    public void testFindByNameInOrAgeLessThan() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.findByNameInOrAgeLessThan(Lists.newArrayList("test1", "test2", "test3"), 22)));
    }

    @Test
    public void testFindByNameAndOrAgeLessThan() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.findByNameInAndAgeLessThan(Lists.newArrayList("test1", "test2", "test3"), 22)));
    }

    @Test
    public void testGetEmployeeById() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.getEmployeeByMaxId()));
    }

    @Test
    public void testQueryParams1() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.queryParams1("sakura", 27)));
    }

    @Test
    public void testQueryParams2() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.queryParams2("sakura", 27)));
    }

    @Test
    public void testQueryLike1() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.queryLike1("test")));
    }

    @Test
    public void testQueryLike2() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.queryLike2("test1")));
    }

    @Test
    public void testGetCount() {
        System.out.println(JsonUtils.toPrettyString(employeeRepository.getCount()));
    }
}

