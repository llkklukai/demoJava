package com.example.demo.service;

import com.example.demo.entity.UserInfo;



public interface UserService {
    /**
     * 添加user
     * @param user
     * @return
     */
    boolean insertUser(UserInfo user);

    /**
     * 根据id查询user
     * @param userId
     * @return
     */
    UserInfo selectUserById(String userId);

    /**
     * 登录
     * @param user
     * @return
     */
    boolean login(UserInfo user);
}
