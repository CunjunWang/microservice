package com.cunjunwang.user.repository;

import com.cunjunwang.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by CunjunWang on 2018/8/17.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findByOpenid(String openid);
}
