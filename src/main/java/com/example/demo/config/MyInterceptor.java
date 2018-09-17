package com.example.demo.config;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.JwtUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MyInterceptor implements HandlerInterceptor {

    /**
     * controller层之前拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json; charset=UTF-8");
//        response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
//        response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "token,Content-Type"); //头里传入的参数的key
        System.out.println("token++++++__" + request.getHeader("token"));
        System.out.println("getRequestURI++++++__" + request.getRequestURI());
        JwtUtil jwt = new JwtUtil();
        String URI = request.getRequestURI();
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//
//            String str = "";
//            String wholeStr = "";
//            while((str = reader.readLine()) != null){//一行一行的读取body体里面的内容；
//                wholeStr += str;
//            }
//            JSONObject t=JSONObject.parseObject(wholeStr);//转化成json对象
//
//            System.out.println("getParameter++++++__" + wholeStr);
//        }catch (Exception e){
//            throw new RuntimeException("++"+e.getMessage());
//        }

        String userId = request.getParameter("userId");



        String token = jwt.createJWT(userId, "name", 30000);
        String TOKEN = request.getHeader("token");

        if ("/demo/login".equals(URI)) {
            System.out.println("用户登录" );
            response.setHeader("token", token);
            return true;
        }
        if ("/demo/register".equals(URI)) {
            return true;
        }

        if (TOKEN == token) {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}
