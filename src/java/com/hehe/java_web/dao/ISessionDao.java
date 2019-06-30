package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Session;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "sessionDao")
public interface ISessionDao {
    List<Session> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    Session selectSessionBySessionid(int sessionid);

    Session selectSessionBySessionname(String sessionname);

    int selectCount();

    boolean insert(Session session);

    boolean update(Session session);

    boolean delete(int sessionid);

    int existSessionname(String sessionname);
}
