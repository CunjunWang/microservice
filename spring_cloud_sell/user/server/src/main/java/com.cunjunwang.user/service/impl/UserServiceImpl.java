package com.cunjunwang.user.service.impl;

import com.cunjunwang.user.dataobject.UserInfo;
import com.cunjunwang.user.repository.UserInfoRepository;
import com.cunjunwang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CunjunWang on 2018/8/17.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
