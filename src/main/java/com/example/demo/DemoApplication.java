package com.example.demo;

import com.example.demo.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
        //生成一个token,登陆成功给客户端
        JwtUtil jwt = new JwtUtil();
        String token = jwt.createJWT("1", "name", 30000);
        System.out.println(token);


        //这是客户端调用接口传过来的一个token,用这个方法校验校验
        Claims jwtStr = jwt.parseJWT(token);

        System.out.println(jwtStr);
    }
}
