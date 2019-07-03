package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "labelDao")
public interface ILabelDao {
    //获取所有标签
    List<Label> selectLabelAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

    //插入标签
    Integer insertLabel(Label profile);

    //删除标签
    Integer deleteLabel(Label profile);

    //查询用户的关注标签
    List<Label> selectUserCollectedLabelAll(@Param("user") User user, @Param("offset") int offset, @Param("limit") int limit);

    //获取这个贴子所属的标签
    List<Label> selectPostBelongedLabelAll(@Param("post") Post post, @Param("offset") int offset, @Param("limit") int limit);

    //获取标签总数
    Integer selectLabelCount();

    //通过标签名获取标签
    Label selectLabelByLName(String labelname);
}
