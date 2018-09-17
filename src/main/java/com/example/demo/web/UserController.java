package com.example.demo.web;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Map<String, Object> register(@RequestBody UserInfo user) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.insertUser(user));
        return modelMap;
    }
    @CrossOrigin
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    private Map<String, Object> selectUserById(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        UserInfo userInfo = userService.selectUserById(userId);
        modelMap.put("userInfo", userInfo);
        return modelMap;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Map<String, Object> logIn(@RequestBody UserInfo user) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.login(user));
        modelMap.put("userInfo",userService.selectUserById(user.getUserId()));
        return modelMap;
    }
}
