package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Post;

import java.util.List;

public interface IPostService {
    //发起贴子
    public boolean addPost(Post post);

    //删除贴子
    public boolean delPost(Post post);

    //更新贴子
    public boolean updatePost(Post post);

    //总帖数
    public Integer selectPostCount();

    //根据内容查找贴子
    public List<Post> selectPostByContent(String keyword,int offset,int limit);
}
