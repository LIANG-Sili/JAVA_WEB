package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Reply;

import java.util.List;

public interface ReplyService {

    //获取一个帖子的所有跟帖
    List<Reply> getRepliesOfTopic(Integer topicId);

    //加入一个回复
    boolean addReply(Reply reply);

    //获得一个帖子的跟帖数量
    int replyNum(Integer topicId);
}
