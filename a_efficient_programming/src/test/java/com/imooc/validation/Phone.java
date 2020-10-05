package com.imooc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义手机号约束注解
 *
 * @author zhaobin11@baidu.com
 */
@Documented
@Target({ElementType.FIELD}) // 注解的作用目标
@Retention(RetentionPolicy.RUNTIME) // 注解的保留策略
@Constraint(validatedBy = PhoneValidator.class) // 与约束注解关联的验证器
public @interface Phone {

    // 约束注解验证时的输出信息
    String message() default "手机号校验错误";

    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 约束注解的有效负载
    Class<? extends Payload>[] payload() default {};
}
