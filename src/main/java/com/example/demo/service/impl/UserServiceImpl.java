package com.example.demo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 新增user
     * @param user
     * @return
     */
    @Transactional
    @Override
    public boolean insertUser(UserInfo user) {
        if (user.getUserId() != null && !"".equals(user.getUserId()) && user.getPassword() != null && !"".equals(user.getPassword())) {

            if(this.selectUserById(user.getUserId())!=null){
                throw new RuntimeException("该用户已注册！");
            }

            user.setCreateTime(new Date());
            user.setLastEditTime(new Date());
            try {
                int effectedNum = userDao.insertUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入用户信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入用户信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    /**
     * 根据id查用户
     * @param userId
     * @return
     */
    @Transactional
    @Override
    public UserInfo selectUserById(String userId) {
        return userDao.selectUserById(userId);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public boolean login(UserInfo user){
        if(!StringUtils.isEmpty(user.getUserId())&&!StringUtils.isEmpty(user.getPassword())){
            try {
                UserInfo userInfo=userDao.selectUserById(user.getUserId());
                if (userInfo==null){
                    throw new RuntimeException("该用户未注册！");
                }else {
                    return true;
                }
            }catch (Exception e){
                throw new RuntimeException("查询用户信息失败！"+e.getMessage());
            }

        }else {
            throw new RuntimeException("账号或密码不能为空!");
        }
    }
}
