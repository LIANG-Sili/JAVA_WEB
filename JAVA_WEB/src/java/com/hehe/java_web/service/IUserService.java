package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
//import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    //用于分页显示获取部分用户数,前一个参数是开始的前一个,后一个参数是一共几个;
    public List<User> getPartUser();

    //获取用户
    public User getUser(String username);

    //用户注册
    public boolean addUser(User user);

    //登录验证
    public boolean login(String username, String password);

    //获取用户信息（通过名字）
    public Profile getProfileByUsername(String username);

    //获取用户数
    public Integer getUserCount();

    //更新用户信息
    public boolean updateProfile(String username, Profile profile);

    //删除用户
    public boolean delUser(User user);

    //插入用户信息
    public boolean addProfile(Profile profile);

    public Integer getUserScore(String PUserName);

    public User getUserByUID(Integer UID);
}
