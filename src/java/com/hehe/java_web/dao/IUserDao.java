package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    User selectUserByUserid(int userid);

    User selectUserByUsername(String username);

    int selectCount();

    boolean insert(User user);

    boolean update(User user);

    boolean delete(int userid);
}
