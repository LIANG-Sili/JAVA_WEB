package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.IPostDao;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postService")
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostDao iPostDao;

    @Override
    public boolean addPost(Post post) {
        return iPostDao.insertPost(post) == 1;
    }

    @Override
    public boolean delPost(Post post) {
        return iPostDao.deletePost(post) == 1;
    }

    @Override
    public boolean updatePost(Post post) {
        return iPostDao.deletePost(post) == 1;
    }

    @Override
    public Integer selectPostCount() {
        return iPostDao.selectPostCount();
    }

    //********************************
    @Override
    public List<Post> selectPostByContent(String keyword, int offset, int limit) {
        return null;
    }
}
