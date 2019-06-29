package com.hehe.java_web.service;

import com.hehe.java_web.pojo.User;

public interface UserService {
    //用户注册
    public boolean addUser(User user);

    //登录验证
    public int login(String username,String password);

    // 添加积分
    public boolean addCredit(Integer points,Integer id);

    //检查username是否存在
    public boolean existUsername(String username);

    //获取用户信息（通过名字）
    public User getUserByUsername(String username);

    //获取用户信息（通过id）
    public User getUserById(Integer id);

    //获取用户数
    public int getUserCount();

    //更新用户信息
    public boolean updateUser(User user);
}
