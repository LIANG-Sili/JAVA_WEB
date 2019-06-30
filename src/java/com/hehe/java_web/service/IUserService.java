package com.hehe.java_web.service;

import com.hehe.java_web.pojo.User;

import java.util.List;

public interface IUserService {

    //获取所有用户信息
    public List<User> getAllUser();

    //用于分页显示获取部分用户数,前一个参数是开始的前一个,后一个参数是一共几个;
    public List<User> getPartUser(Integer offset,Integer limit);

    //用户注册
    public boolean addUser(User user);

    //登录验证
    public boolean login(String username,String password);

    // 添加积分
    public boolean addCredit(Integer points,String username);

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

    public boolean delUser(User user);
}
