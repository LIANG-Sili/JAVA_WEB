package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;

import java.util.List;

public interface ICollectService {
    //关注用户
    public boolean userCollectUser(String username1, String username2);

    //取消关注用户
    public boolean userNotCollectUser(String username1, String username2);

    //获取关注人列表
    public List<User> getUserCollectUser(String username );

    //获取被关注人列表
    public List<User> getUserCollectedUser(String username );

    //关注贴子
    public boolean userCollectPost(String username, Integer postID);

    //取消关注贴子
    public boolean userNotCollectPost(String username, Integer postID);

    //获取用户关注贴子列表
    public List<Post> getUserCollectPost(String username );

    //关注标签
    public boolean userCollectLabel(String username, String labelname);

    //取消关注标签
    public boolean userNotCollectLabel(String username, String labelname);

    //获取关注标签列表
    public List<Label> getUserCollectLabel(String username);

    //获取贴子的标签列表
    public List<Label> getPostBelongLabel(Integer postID);

    //增加贴子属于标签
    public boolean insertPostBelongLabel(Post post, Label label);

    //删除贴子属于标签
    public boolean deletePostBelongLabel(Post post, Label label);

    //用户关注标签数量
    public Integer selectUserCollectLabelCount(Integer UID);
}
