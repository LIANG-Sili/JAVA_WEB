package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.IUserDao;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Resource private IUserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.selectAll(0,-1);
    }

    @Override
    public List<User> getPartUser(Integer offset,Integer limit){

        return userDao.selectAll(offset,limit);
    }

    @Override
    public boolean addUser(User user) {
        if(!existUsername(user.getUname())){
            userDao.insert(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        if(existUsername(username)) {
            return userDao.selectUserByUsername(username).getUpassword().equals(password);
        }
        return false;
    }

    @Override
    public boolean addCredit(Integer points, String username) {
        if(existUsername(username))
        {
            User user = userDao.selectUserByUsername(username);
            user.setUpoint(user.getUpoint()+points);
            userDao.update(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean existUsername(String username) {
        return userDao.existUsername(username) == 1;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.selectUserByUserid(id);
    }

    @Override
    public int getUserCount() {
        return userDao.selectCount();
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delUser(User user) {
        if(existUsername(user.getUname())){
            userDao.delete(user.getUid());
            return true;
        }
        return false;
    }
}
