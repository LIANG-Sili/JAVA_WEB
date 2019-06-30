package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.ISessionDao;
import com.hehe.java_web.pojo.Session;
import com.hehe.java_web.service.ISessionService;

import javax.annotation.Resource;
import java.util.List;

public class SessionServiceImpl implements ISessionService {
    @Resource private ISessionDao sessionDao;

    @Override
    public List<Session> getAllSessions() {
        return sessionDao.selectAll(0,-1);
    }

    @Override
    public List<Session> getPartSessions(int offset,int limit){
        return sessionDao.selectAll(offset, limit);
    }

    @Override
    public boolean existSessionname(String sessionname){
        return sessionDao.existSessionname(sessionname) == 1;
    }
    @Override
    public Session getBySessionName(String sessionname) {
        return sessionDao.selectSessionBySessionname(sessionname);
    }

    @Override
    public boolean addSession(Session session) {
        if(!existSessionname(session.getSname())){
            sessionDao.insert(session);
            return true;
        }
        return false;
    }

    @Override
    public boolean delSession(Session session) {
        if(existSessionname(session.getSname())){
            sessionDao.delete(session.getSid());
            return true;
        }
        return false;
    }
}
