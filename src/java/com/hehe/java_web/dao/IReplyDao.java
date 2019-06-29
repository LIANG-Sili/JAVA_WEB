package com.hehe.java_web.dao;


import com.hehe.java_web.pojo.Reply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "replyDao")
public interface IReplyDao {
    List<Reply> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    Reply selectReplyByReplyid(int replyid);

    int selectCount();

    boolean insert(Reply reply);

    boolean update(Reply reply);

    boolean delete(int replyid);
}
