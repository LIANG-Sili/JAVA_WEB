package com.hehe.java_web.test;/*package com.hehe.java_web.test;

import com.hehe.java_web.dao.IPostDao;
import com.hehe.java_web.dao.IUserDao;
import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.ICollectService;
import com.hehe.java_web.service.ILabelService;
import com.hehe.java_web.service.IPostService;
import com.hehe.java_web.service.IUserService;
import com.hehe.java_web.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.core.Application;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {

//    @Autowired
//    IUserDao iUserDao;

    @Test
    public void test2()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String ntime = sdf.format(new Date());

        IUserService userService = context.getBean("userService",IUserService.class);

        //        System.out.println(userService.getUser("Lelouch"));

//        User user = new User("kurito", "123", ntime);

//        userService.delUser(user);

//        System.out.println(userService.getPartUser(0, 4));

//        System.out.println(userService.getProfileByUsername("Lelouch"));

//        System.out.println(userService.getUserCount());

//        System.out.println(userService.login("Lelouch", "456"));

//        Profile tempProfile = userService.getProfileByUsername("Lelouch");
//        tempProfile.setPStatement("修改个人信息");
//        userService.updateProfile("Lelouch", tempProfile);

        ILabelService iLabelService = context.getBean("labelService", ILabelService.class);

//        Label label = new Label(9, "蓬莱鬼话");

//        iLabelService.addLabel(label);

//        iLabelService.delLabel(iLabelService.getLabelAll(0, 5).get(4));

//        System.out.println(iLabelService.getLabelCount());

        IPostService iPostService = context.getBean("postService", IPostService.class);

        Post post = new Post(2, "这是一个测试样例", ntime, 0, 1);

//        iPostService.addPost(post);

//        此处需要再测试 /*
//        System.out.println(iPostService.selectPostByContent("测试", 0, 3));

        Post tempPost = iPostService.selectPostByContent("测试",0,4).get(0);

//        System.out.println(iPostService.selectPostCount(1));

//        tempPost.setPContents("是否修改成功");

//        iPostService.updatePost(tempPost);

//        System.out.println(iPostService.delPost(tempPost));

        ICollectService iCollectService = context.getBean("collectService", ICollectService.class);

//        iCollectService.userCollectUser("Lelouch", "Sherly");

//        iCollectService.userCollectLabel("Lelouch", "娱乐八卦");

//        iCollectService.userCollectPost("Lelouch", 3);

//        System.out.println(iCollectService.getPostBelongLabel(1, 0, 2));

//        System.out.println(iCollectService.getUserCollectedUser("Lelouch", 0, 1));

//        System.out.println(iCollectService.getUserCollectLabel("Lelouch", 0, 1));

//        System.out.println(iCollectService.getUserCollectPost("Lelouch", 0, 1));

//        System.out.println(iCollectService.getUserCollectUser("Lelouch", 0, 1));

//        iCollectService.userNotCollectLabel("Lelouch", "娱乐八卦");

//        iCollectService.userNotCollectPost("Lelouch", 3);

//        iCollectService.userNotCollectUser("Lelouch", "Sherly");

//        System.out.println();
        //        userService.addUser(user);

//        UserServiceImpl userService = new UserServiceImpl();
//        System.out.println(userService.getUserCount());
//
//
//        System.out.println(iUserDao.selectUserByUsername("Lelouch"));
    }
}
*/