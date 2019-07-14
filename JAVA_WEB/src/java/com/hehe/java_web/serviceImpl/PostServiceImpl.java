package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.IPostDao;
import com.hehe.java_web.dao.IProfileDao;
import com.hehe.java_web.dao.IUserDao;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postService")
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostDao iPostDao;

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private IProfileDao iProfileDao;

    @Override
    public boolean addPost(Post post, String PUserName) {
        return iPostDao.insertPost(post) == 1;
    }

    @Override
    public boolean delPost(Post post, String PUserName) {
            return iPostDao.deletePost(post) == 1;
    }

    @Override
    public boolean updatePost(Post post, User user) {
        return iPostDao.updatePost(post) == 1;

    }

    @Override
    public Integer selectPostCount(Integer type) {
        return iPostDao.selectPostCount(type);
    }

    @Override
    public List<Post> selectPostByContent(String keyword) {
        keyword = "%" + keyword + "%";
        return iPostDao.selectPostByContent(keyword);
    }

    //查询指定用户发表过的贴子
    @Override
    public List<Post> selectUserPostAll(User user) {
        return iPostDao.selectUserPostAll(user);
    }

    //查询指定用户发表过的贴子
    @Override
    public List<Post> selectUserReplyAll(User user) {
        return iPostDao.selectUserReplyAll(user);
    }

    //通过PostId获取Post
    @Override
    public Post selectPostByPID(Integer PID) {
        return iPostDao.selectPostByPID(PID);
    }

    //获取所有贴子
    @Override
    public List<Post> selectPostAll() {
        return iPostDao.selectPostAll();
    }

    //获取所有回贴
    @Override
    public List<Post> selectPostReplyAll(Integer PID) {
        return iPostDao.selectBelongedPostAll(iPostDao.selectPostByPID(PID));
    }
}
