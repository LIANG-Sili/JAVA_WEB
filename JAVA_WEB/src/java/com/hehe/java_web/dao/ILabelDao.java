package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ILabelDao {
    //获取所有标签
    List<Label> selectLabelAll();

    //插入标签
    Integer insertLabel(Label profile);

    //删除标签
    Integer deleteLabel(Label profile);

    //查询用户的关注标签
    List<Label> selectUserCollectedLabelAll(@Param("user") User user);

    //获取这个贴子所属的标签
    List<Label> selectPostBelongedLabelAll(@Param("post") Post post);

    //获取标签总数
    Integer selectLabelCount();

    //通过标签名获取标签
    Label selectLabelByLName(String labelname);

    //用户关注标签数量
    Integer selectUserCollectLabelCount(Integer UID);
}
