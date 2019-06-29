package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Topic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "topicDao")
public interface ITopicDao {
    List<Topic> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    Topic selectTopicByTopicid(int topicid);

    Topic selectCount();

    boolean insert(Topic topic);

    boolean update(Topic topic);

    boolean delete(int topicid);
}
