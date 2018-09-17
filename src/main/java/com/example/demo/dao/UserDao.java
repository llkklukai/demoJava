package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {
    /**
     * 注册用户
     * @param user
     * @return
     */
    int insertUser(UserInfo user);

    /**
     * 根据ID查询user
     * @param userId
     * @return
     */
    UserInfo selectUserById(String userId);
}
