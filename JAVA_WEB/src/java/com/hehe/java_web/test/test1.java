package com.hehe.java_web.test;

import com.hehe.java_web.dao.ILabelDao;
import com.hehe.java_web.dao.IPostDao;
import com.hehe.java_web.dao.IProfileDao;
import com.hehe.java_web.dao.IUserDao;
import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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

//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//            String time = sdf.format(new Date());

//            Label label = new Label("情感天地");

//            Post post = new Post(null, "测试内容", time, 1, 1);

//            IPostDao iPostDao = openSession.getMapper(IPostDao.class);
//            iPostDao.insertPost(post);

//            User user = new User("Lelouch", "456", time);

//            user.setUStatus(0);

            IUserDao iUserDao = openSession.getMapper(IUserDao.class);

//            System.out.println(iPostDao.selectUserCollectPostAll(iUserDao.selectUserByUsername("Lelouch"), 0, 1));


//            iUserDao.insertUser(user);

//            iUserDao.deleteUser(user);

//            iUserDao.updateUser(user);

//            System.out.println(iUserDao.selectUserCount());

//            System.out.println(iUserDao.selectUserAll(0, 3));

            System.out.println(iUserDao.selectUserByUsername("hehe"));

//            iUserDao.insertUserCollectLabel(iUserDao.selectUserByUsername("Lelouch"), label);

//            iUserDao.deleteUserCollectLabel(iUserDao.selectUserByUsername("Lelouch"), label);

//            iUserDao.insertUserCollectPost(iUserDao.selectUserByUsername("Lelouch"), iPostDao.selectPostAll(0, 1).get(0));
//            System.out.println(iUserDao.selectUserCollectPostAll(iPostDao.selectPostAll(0, 1).get(0), 0, 1));
//            iUserDao.deleteUserCollectPost(iUserDao.selectUserByUsername("Lelouch"), iPostDao.selectPostAll(0, 1).get(0));

//            iUserDao.insertUserCollectUser(iUserDao.selectUserByUsername("Jackhehe"), iUserDao.selectUserByUsername("Lelouch"));
//            iUserDao.insertUserCollectUser(iUserDao.selectUserByUsername("Jackhehe"), iUserDao.selectUserByUsername("Sherly"));
//
//
//            System.out.println(iUserDao.selectUserCollectCount(iUserDao.selectUserByUsername("Jackhehe")));
//
//            System.out.println(iUserDao.selectUserCollectAll(iUserDao.selectUserByUsername("Jackhehe"), 0, 2));
//
//            System.out.println(iUserDao.selectUserCollectedCount(iUserDao.selectUserByUsername("Lelouch")));
//
//            System.out.println(iUserDao.selectUserCollectedAll(iUserDao.selectUserByUsername("Lelouch"), 0, 1));

//            iUserDao.deleteUserCollectUser(iUserDao.selectUserByUsername("Jackhehe"),iUserDao.selectUserByUsername("Sherly"));

//            iPostDao.insertPostBelongLabel(iPostDao.selectPostAll(0, 1).get(0), label);

//            ILabelDao iLabelDao = openSession.getMapper(ILabelDao.class);

//            System.out.println(iPostDao.selectPostBelongLabelAll(label, 0, 1));

//            System.out.println(iUserDao.selectUserCollectLabelAll(label, 0, 1));

//            System.out.println(iLabelDao.selectUserCollectedLabelAll(iUserDao.selectUserByUsername("Lelouch"), 0, 1));

//            System.out.println(iLabelDao.selectPostBelongedLabelAll(iPostDao.selectPostAll(0, 1).get(0), 0, 1));

//            System.out.println(iLabelDao.selectLabelCount());

//            System.out.println(iLabelDao.selectLabelByLName("情感天地"));

//            iLabelDao.deleteLabel(label);

//            System.out.println(iPostDao.selectPostAll(0, 3));
//
//            System.out.println(iPostDao.selectBelongPost(iPostDao.selectPostAll(0, 3).get(2)));
//
//            System.out.println(iPostDao.selectUserPostAll(iUserDao.selectUserByUsername("Lelouch"),0 , 2));
//
//            System.out.println(iPostDao.selectBelongedPostAll(iPostDao.selectPostAll(0, 3).get(0),0 , 1));
//
//            Post tempPost = iPostDao.selectPostAll(0, 3).get(0);
//            tempPost.setPContents("修改内容");
//            tempPost.setPFlag(0);
//            tempPost.setPTimes("2019-07-02");
//            iPostDao.updatePost(tempPost);

//            IProfileDao iProfileDao = openSession.getMapper(IProfileDao.class);

//            Profile profile = iProfileDao.selectProfileByUserName("Lelouch");

//            System.out.println(profile);

//            profile.setPStatement("此人留下了些什么");
//            iProfileDao.updateProfile(profile);

//            iProfileDao.deleteProfile(profile);

//            iProfileDao.deleteProfile()

//            openSession.commit();
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


