package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IUserDao {
    //查询所有用户可分页
    List<User> selectUserAll();

    //查询关注用户可分页
    List<User> selectUserCollectAll(@Param("user") User user);

    //查询被关注用户可分页
    List<User> selectUserCollectedAll(@Param("user") User user);

    //根据用户名查用户
    User selectUserByUsername(@Param("username") String username);

    //根据用户ID查用户
    User selectUserByUID(@Param("uid") Integer uid);

    //查询用户数量
    Integer selectUserCount();

    //关注人数
    Integer selectUserCollectCount(User user);

    //被关注人数
    Integer selectUserCollectedCount(User user);

    //插入用户
    Integer insertUser(User user);

    //更新用户
    Integer updateUser(User user);

    //删除用户
    Integer deleteUser(User user);
////////////////////////////////////////////////////////////
    //用户取消关注某个用户
    Integer deleteUserCollectUser(@Param("user1") User user1, @Param("user2") User user2);

    //用户取消关注某个标签
    Integer deleteUserCollectLabel(@Param("user") User user, @Param("label") Label label);

    //用户取消关注某个贴子
    Integer deleteUserCollectPost(@Param("user") User user, @Param("post") Post post);

    //用户关注某个用户
    Integer insertUserCollectUser(@Param("user1") User user1, @Param("user2") User user2);

    //用户关注某个标签
    Integer insertUserCollectLabel(@Param("user") User user, @Param("label") Label label);

    //用户关注某个贴子
    Integer insertUserCollectPost(@Param("user") User user, @Param("post") Post post);

    //获取关注这个贴子的人
    List<User> selectUserCollectPostAll(@Param("post") Post post);

    //获取关注标签的用户
    List<User> selectUserCollectLabelAll(@Param("label") Label label);
}
