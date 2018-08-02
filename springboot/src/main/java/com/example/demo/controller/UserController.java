package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("getUsers")
    @ResponseBody
    public String getUsers() {
        HashMap<String,Object> map = new HashMap<>();
        List<User> list = userService.selectUsers(map);
        return JSON.toJSONString(list);
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(String id) {
        boolean flag = false;
        int result = userService.deleteUser(Long.parseLong(id));
        if (result > 0) {
            flag = true;
        }
        return JSON.toJSONString(flag);
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(@RequestBody User user) {
        boolean flag = false;
        int result = userService.insert(user);
        if (result > 0) {
            flag = true;
        }
        return JSON.toJSONString(flag);
    }


    @RequestMapping("getById")
    @ResponseBody
    public User getById(String id) {
        User user = userService.getById(Long.parseLong(id));
        return user;
    }

    @RequestMapping("hello")
    public String hello() {
        return "index";
    }

}