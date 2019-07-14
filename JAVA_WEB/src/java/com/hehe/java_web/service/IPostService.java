package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPostService {
    //发起贴子
    public boolean addPost(Post post, String PUserName);

    //删除贴子
    public boolean delPost(Post post, String PUserName);

    //更新贴子
    public boolean updatePost(Post post, User user);

    //总帖数
    public Integer selectPostCount(Integer type);

    //根据内容查找贴子
    public List<Post> selectPostByContent(String keyword);

    //查询指定用户发表过的贴子
    public List<Post> selectUserPostAll(User user);

    //查询指定用户发表过的贴子
    public List<Post> selectUserReplyAll(User user);

    //通过PostId获取Post
    public Post selectPostByPID(Integer PID);

    //获取所有贴子
    public List<Post> selectPostAll();

    //获取贴子的所有子贴
    public List<Post> selectPostReplyAll(Integer PID);
}
