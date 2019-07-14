package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IPostDao {
    //获取所有贴子
    List<Post> selectPostAll();

    //获取他所依赖的贴子
    Post selectBelongPost(Post post);

    //获取一个用户发起的所有贴子
    List<Post> selectUserPostAll(@Param("user") User user );

    //获取一个用户发起的所有贴子
    List<Post> selectUserReplyAll(@Param("user") User user );

    //获取这个贴子的所有子贴
    List<Post> selectBelongedPostAll(@Param("post") Post post );

    //插入一个贴子
    Integer insertPost(Post post);

    //更新一个贴子
    Integer updatePost(Post post);

    //删除一个贴子
    Integer deletePost(Post post);

    //增加贴子的标签
    Integer insertPostBelongLabel(@Param("post") Post post, @Param("label") Label label);

    //删除贴子的标签
    Integer deletePostBelongLabel(@Param("post") Post post, @Param("label") Label label);

    //查询用户的关注贴子
    List<Post> selectUserCollectPostAll(@Param("user") User user );

    //获取贴子总数
    Integer selectPostCount(@Param("type") Integer type);

    //通过PostId获取Post
    Post selectPostByPID(Integer PID);

    //获取标签的所有贴子
    List<Post> selectPostBelongLabelAll(@Param("label") Label label);

    //通过模糊查询获得所有贴子
    List<Post> selectPostByContent(@Param("keyword") String keyword);
}
