package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.ITopicDao;
import com.hehe.java_web.pojo.Topic;
import com.hehe.java_web.service.ITopicService;

import javax.annotation.Resource;
import java.util.List;

public class TopicServiceImpl implements ITopicService {
    @Resource private ITopicDao topicDao;

    @Override
    public List<Topic> getAllTopics() {
        return topicDao.selectAll(0,-1);
    }

    @Override
    public List<Topic> listOrderByCommentsTopics() {
        return null;
    }

    @Override
    public List<Topic> listOrderByCountsTopics() {
        return null;
    }

    @Override
    public Topic selectById(Integer id) {
        return topicDao.selectTopicByTopicid(id);
    }

    @Override
    public List<Topic> selectUsernameTopics(String username) {
        return null;
    }

    @Override
    public List<Topic> selectSessionnameTopics(String sessionname) {
        return null;
    }

    @Override
    public boolean addTopic(Topic topic) {
        return false;
    }

    @Override
    public boolean clickAddOne(Integer id) {
        return false;
    }

    @Override
    public int getTopicsNum() {
        return topicDao.selectCount();
    }
}
