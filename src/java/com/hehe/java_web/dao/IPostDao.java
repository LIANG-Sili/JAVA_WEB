package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postDao")
public interface IPostDao {
    //获取所有贴子
    List<Post> selectPostAll(@Param("offset") int offset, @Param("limit") int limit);

    //获取他所依赖的贴子
    Post selectBelongPost(Post post);

    //获取一个用户发起的所有贴子
    List<Post> selectUserPostAll(@Param("user") User user, @Param("offset") int offset, @Param("limit") int limit);

    //获取这个贴子的所有子贴
    List<Post> selectBelongedPostAll(@Param("post") Post post, @Param("offset") int offset, @Param("limit") int limit);

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
    List<Post> selectUserCollectPostAll(@Param("user") User user, @Param("offset") int offset, @Param("limit") int limit);

    //获取贴子总数
    Integer selectPostCount();

    //通过PostId获取Post
    Post selectPostByPID(Integer PID);

    //获取标签的所有贴子
    List<Post> selectPostBelongLabelAll(@Param("label") Label label, @Param("offset") Integer offset, @Param("limit") Integer limit);

}
