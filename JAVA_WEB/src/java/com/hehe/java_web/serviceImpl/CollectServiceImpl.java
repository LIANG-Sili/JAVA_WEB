package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.ILabelDao;
import com.hehe.java_web.dao.IPostDao;
import com.hehe.java_web.dao.IUserDao;
import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "collectService")
public class CollectServiceImpl implements ICollectService {
    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private IPostDao iPostDao;

    @Autowired
    private ILabelDao iLabelDao;

    @Override
    public boolean userCollectUser(String username1, String username2) {
        User user1 = iUserDao.selectUserByUsername(username1);
        User user2 = iUserDao.selectUserByUsername(username2);
        if (user1 != null && user2 != null) {
            return iUserDao.insertUserCollectUser(user1, user2) == 1;
        }
        return false;
    }

    @Override
    public boolean userNotCollectUser(String username1, String username2) {
        User user1 = iUserDao.selectUserByUsername(username1);
        User user2 = iUserDao.selectUserByUsername(username2);
        if (user1 != null && user2 != null) {
            return iUserDao.deleteUserCollectUser(user1, user2) == 1;
        }
        return false;
    }

    @Override
    public List<User> getUserCollectUser(String username) {
        User temp = iUserDao.selectUserByUsername(username);
        if (temp != null) {
            return iUserDao.selectUserCollectAll(temp);
        }
        return null;
    }

    @Override
    public List<User> getUserCollectedUser(String username) {
        User temp = iUserDao.selectUserByUsername(username);
        if (temp != null) {
            return iUserDao.selectUserCollectedAll(temp);
        }
        return null;
    }

    @Override
    public boolean userCollectPost(String username, Integer postID) {
        User user = iUserDao.selectUserByUsername(username);
        Post post = iPostDao.selectPostByPID(postID);
        if (user != null && post != null) {
            return iUserDao.insertUserCollectPost(user, post) == 1;
        }
        return false;
    }

    @Override
    public boolean userNotCollectPost(String username, Integer postID) {
        User user = iUserDao.selectUserByUsername(username);
        Post post = iPostDao.selectPostByPID(postID);
        if (user != null && post != null) {
            return iUserDao.deleteUserCollectPost(user, post) == 1;
        }
        return false;
    }

    @Override
    public List<Post> getUserCollectPost(String username) {
        User temp = iUserDao.selectUserByUsername(username);
        if (temp != null) {
            return iPostDao.selectUserCollectPostAll(temp);
        }
        return null;
    }

    @Override
    public boolean userCollectLabel(String username, String labelname) {
        User user = iUserDao.selectUserByUsername(username);
        Label label = iLabelDao.selectLabelByLName(labelname);
        if (user != null && label != null) {
            return iUserDao.insertUserCollectLabel(user, label) == 1;
        }
        return false;
    }

    @Override
    public boolean userNotCollectLabel(String username, String labelname) {
        User user = iUserDao.selectUserByUsername(username);
        Label label = iLabelDao.selectLabelByLName(labelname);
        if (user != null && label != null) {
            return iUserDao.deleteUserCollectLabel(user, label) == 1;
        }
        return false;
    }
///
    @Override
    public List<Label> getUserCollectLabel(String username) {
        User temp = iUserDao.selectUserByUsername(username);
        if (temp != null) {
            return iLabelDao.selectUserCollectedLabelAll(temp);
        }
        return null;
    }

    @Override
    public List<Label> getPostBelongLabel(Integer postID) {
        Post temp = iPostDao.selectPostByPID(postID);
        if (temp != null) {
            return iLabelDao.selectPostBelongedLabelAll(temp);
        }
        return null;
    }

    @Override
    //增加贴子属于标签
    public boolean insertPostBelongLabel(Post post, Label label) {
        return iPostDao.insertPostBelongLabel(post,label) == 1;
    }

    @Override
    //删除贴子属于标签
    public boolean deletePostBelongLabel(Post post, Label label) {
        return iPostDao.deletePostBelongLabel(post, label) == 1;
    }

    @Override
    //用户关注标签数量
    public Integer selectUserCollectLabelCount(Integer UID) {
        return iLabelDao.selectUserCollectLabelCount(UID);
    }
}
