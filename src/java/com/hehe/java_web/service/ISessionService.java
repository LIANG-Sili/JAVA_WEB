package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Session;

import java.util.List;

public interface ISessionService {

    //获得所有版块
    List<Session> getAllSessions();

    //获得部分版块
    List<Session> getPartSessions(int offset,int limit);

    //通过版块名称获取版块
    Session getBySessionName(String sessionname);

    //检查sessionname是否存在
    boolean existSessionname(String sessionname);

    //增加一个版块
    boolean addSession(Session session);

    //删除一个版块
    boolean delSession(Session session);
}
