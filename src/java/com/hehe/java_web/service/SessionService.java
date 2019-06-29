package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Session;

import java.util.List;

public interface SessionService {

    //获得所有版块
    List<Session> getAllSessions();

    //通过版块名称获取版块
    Session getBySesstionName(String setionname);

    //增加一个版块
    boolean addSession(Session session);

    //删除一个版块
    boolean delSession(Session session);
}
