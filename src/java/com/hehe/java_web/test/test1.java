package com.hehe.java_web.test;

import com.hehe.java_web.dao.IProfileDao;
import com.hehe.java_web.dao.IUserDao;
import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test1 {
    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "spring/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void test1() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            IUserDao iUserDao = openSession.getMapper(IUserDao.class);
            System.out.println(iUserDao.selectUserCount());
        }finally {
            openSession.close();
        }
    }
}


//    IProfileDao iProfileDao = openSession.getMapper(IProfileDao.class);
//            Profile profile = new Profile();
//
//            iProfileDao.insertProfile(profile);

//            User user = new User("hehe","147258");
//            iUserDao.insertUser(user);
//            user = iUserDao.selectUserByUsername("hehe");
//            System.out.println(user.toString());
//
//            iUserDao.deleteUser(user);
//            System.out.println(iUserDao.selectUserByUsername("hehe").toString());
