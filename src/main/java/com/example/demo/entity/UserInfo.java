package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {
    //主键ID
    private Integer id;
    //用户ID
    private String userId;
    //用户密码
    private  String password;
    //创建时间
    private Date createTime;
    //修改时间
    private Date lastEditTime;
}
