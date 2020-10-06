package com.imooc;

import com.imooc.dao.IUserDao;
import com.imooc.domain.User;
import com.imooc.utils.JsonUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhaobin11@baidu.com
 */
public class MyBatisTest {

    @Test
    public void test1() throws IOException {
        // 1. 读取配置文件
        // 绝对路径、相对路径都有坑
        // 一般用ServletContext对象的getRealPath()或者类加载器读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2. 创建SqlSessionFactory工厂
        // 构建者模式：把对象的创建细节隐藏
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        // 3. 生产SqlSession对象
        // 工厂模式：降低类与类间的依赖关系
        SqlSession session = factory.openSession();

        // 4. SqlSession创建Dao接口的代理对象
        // 代理模式：不修改源码的基础上对已有方法增强
        IUserDao userDao = session.getMapper(IUserDao.class);

        // 5. 代理对象执行方法
        List<User> userList = userDao.findAllByAnnotation();
        System.out.println(JsonUtils.toPrettyString(userList));

        // 6. 释放资源
        session.close();
        in.close();
    }
}
