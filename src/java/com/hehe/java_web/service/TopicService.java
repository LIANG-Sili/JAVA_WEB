package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Topic;

import java.util.List;

public interface TopicService {

    //获取全部帖子
    List<Topic> getAllTopics();

    //获取按评论数量降序的帖子列表
    List<Topic> listOrderByCommentsTopics();

    //获取按评论点击量降序的帖子列表
    List<Topic> listOrderByCountsTopics();

    //获取指定ID帖子
    Topic selectById(Integer id);

    //获取指定用户的帖子
    List<Topic> selectUsernameTopics(String username);

    //获取指定版块的帖子
    List<Topic> selectSessionnameTopics(String sessionname);

    //新建帖子
    boolean addTopic(Topic topic);

    //点击量加一
    boolean clickAddOne(Integer id);

    //获取帖子总数
    int getTopicsNum();
}
