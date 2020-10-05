package com.imooc.validation;

import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Set;

/**
 * @author zhaobin11@baidu.com
 */
public class ValidationTest {

    // 验证器对象
    private Validator validator;

    // 待验证对象
    private UserInfo userInfo;

    private Set<ConstraintViolation<UserInfo>> set;

    private Set<ConstraintViolation<UserInfoService>> otherSet;

    @Before
    public void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        userInfo = new UserInfo();
        userInfo.setUserId("1027");
        userInfo.setUserName("sakura");
        userInfo.setPassword("10271027");
        userInfo.setEmail("zhaobin11@baidu.com");
        userInfo.setAge(27);
        userInfo.setPhone("15800000000");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.JANUARY, 1);
        userInfo.setBirthday(calendar.getTime());
        userInfo.setFriends(Lists.newArrayList(userInfo));
    }

    @After
    public void print() {
        set.forEach(item -> System.out.println(item.getMessage()));
//        otherSet.forEach(item -> System.out.println(item.getMessage()));
    }

    @Test
    public void nullValidation() {
        set = validator.validate(userInfo);
    }

    @Test
    public void groupValidation() {
        set = validator.validate(userInfo, UserInfo.RegisterGroup.class);
    }

    @Test
    public void groupSequenceValidation() {
        set = validator.validate(userInfo, UserInfo.Group.class);
    }

    /**
     * 对方法输入参数进行约束注解校验
     */
    @Test
    public void paramValidation() throws NoSuchMethodException {
        // 获取验证执行器
        ExecutableValidator executableValidator = validator.forExecutables();

        UserInfoService service = new UserInfoService();
        // 待验证方法
        Method method = service.getClass().getMethod("setUserInfo", UserInfo.class);
        // 方法输入参数
        Object[] paramObjects = new Object[]{new UserInfo()};

        // 对方法的输入参数进行校验
        otherSet = executableValidator.validateParameters(
                service,
                method,
                paramObjects);
    }

    /**
     * 对方法返回值进行约束校验
     */
    @Test
    public void returnValueValidation() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ExecutableValidator executableValidator = validator.forExecutables();

        UserInfoService service = new UserInfoService();
        Method method = service.getClass().getMethod("getUserInfo");
        Object returnValue = method.invoke(service);

        otherSet = executableValidator.validateReturnValue(
                service,
                method,
                returnValue);

    }

    /**
     * 对构造函数输入参数进行校验
     */
    @Test
    public void constructorValidation() throws NoSuchMethodException {
        ExecutableValidator executableValidator = validator.forExecutables();

        Constructor<UserInfoService> constructor = UserInfoService.class.getConstructor(UserInfo.class);
        Object[] paramObjects = new Object[]{new UserInfo()};

        otherSet = executableValidator.validateConstructorParameters(constructor, paramObjects);
    }
}
