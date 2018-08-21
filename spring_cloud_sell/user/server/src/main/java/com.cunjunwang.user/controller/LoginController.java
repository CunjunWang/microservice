package com.cunjunwang.user.controller;

import com.cunjunwang.user.VO.ResultVO;
import com.cunjunwang.user.constant.CookieConstant;
import com.cunjunwang.user.constant.RedisConstant;
import com.cunjunwang.user.dataobject.UserInfo;
import com.cunjunwang.user.enums.ResultEnum;
import com.cunjunwang.user.enums.RoleEnum;
import com.cunjunwang.user.service.UserService;
import com.cunjunwang.user.utils.CookieUtil;
import com.cunjunwang.user.utils.ResultVOUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by CunjunWang on 2018/8/17.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {
        // 1. openid 和数据库里的数据进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAILED);
        }

        // 2. 判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3. 设置cookie为openid=abc
        CookieUtil.set(response, CookieConstant.OPEN_ID, openid, CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }

    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletRequest request,
                           HttpServletResponse response) {

        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie != null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue()
                .get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }

        // 1. openid 和数据库里的数据进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAILED);
        }

        // 2. 判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3. 写入Redis key=UUID, value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.EXPIRE;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid, expire, TimeUnit.SECONDS);

        // 4. 设置cookie为token = UUID
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }
}
