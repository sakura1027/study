package com.imooc.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 待验证对象
 *
 * @author zhaobin11@baidu.com
 */
@Data
public class UserInfo {

    // 登录场景
    public interface LoginGroup {
    }

    // 注册场景
    public interface RegisterGroup {
    }

    // 组排序场景
    @GroupSequence({
            LoginGroup.class,
            RegisterGroup.class,
            Default.class
    })
    public interface Group {

    }

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空", groups = LoginGroup.class)
    private String userId;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名称不能为空")
    private String userName;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度不能少于6位，多于20位")
    private String password;

    /**
     * 邮箱
     */
    @Email(message = "邮箱必须为有效邮箱", groups = RegisterGroup.class)
    private String email;

    /**
     * 手机号
     */
    @Phone(message = "手机号不是158后头随便")
    private String phone;

    /**
     * 年龄
     */
    @Min(value = 18, message = "年龄不能小于18岁")
    @Max(value = 60, message = "年龄不能大于60岁")
    private Integer age;

    /**
     * 生日
     */
    @Past(message = "生日不能为未来时间点")
    private Date birthday;

    /**
     * 好友列表
     */
    @Size(min = 1, message = "不能少于1个好友")
    private List<@Valid UserInfo> friends; // 级联验证
}
