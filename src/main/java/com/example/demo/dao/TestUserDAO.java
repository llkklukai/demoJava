package com.example.demo.dao;

import com.example.demo.entity.TestUser;
import org.springframework.stereotype.Repository;

/**
 * TestUserDAO继承基类
 */
@Repository
public interface TestUserDAO extends MyBatisBaseDao<TestUser, Integer> {
}