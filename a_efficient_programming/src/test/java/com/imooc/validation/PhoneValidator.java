package com.imooc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义手机号约束注解关联验证器
 *
 * @author zhaobin11@baidu.com
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    /**
     * 自定义校验逻辑方法
     *
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String check = "158\\d{8}";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(value);
        return matcher.matches();
    }
}
