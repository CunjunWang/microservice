package com.cunjunwang.user.service;

import com.cunjunwang.user.dataobject.UserInfo;

/**
 * Created by CunjunWang on 2018/8/17.
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
