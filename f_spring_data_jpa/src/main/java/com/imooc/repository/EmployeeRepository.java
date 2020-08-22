package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhaobin11@baidu.com
 */
// @RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository extends Repository<Employee, Integer> {

    Employee findByName(String name);

    // where name like ?% and age < ?
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    // where name like %? and age < ?
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    // where name in (?,?....) or age < ?
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    // where name in (?,?....) and age < ?
    List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer age);

    @Query("select o from Employee o where id = (select max(id) from Employee)")
    Employee getEmployeeByMaxId();

    @Query("select o from Employee o where o.name = ?1 and age = ?2")
    List<Employee> queryParams1(String name, Integer age);

    @Query("select o from Employee o where o.name = :name and age = :age")
    List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    @Query(nativeQuery = true, value = "select count(1) from employee")
    long getCount();

    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);
}
