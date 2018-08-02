package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<User> selectUsers(HashMap map);
    User getById(Long id);

    int deleteUser(Long id);

    int insert(User user);
}