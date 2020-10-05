package com.imooc.validation;

import javax.validation.Valid;

/**
 * @author zhaobin11@baidu.com
 */
public class UserInfoService {

    public void setUserInfo(@Valid UserInfo userInfo) {

    }

    public @Valid UserInfo getUserInfo() {
        return new UserInfo();
    }

    public UserInfoService() {

    }

    public UserInfoService(@Valid UserInfo userInfo) {

    }
}
