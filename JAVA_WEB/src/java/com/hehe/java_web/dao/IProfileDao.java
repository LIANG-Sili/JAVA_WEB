package com.hehe.java_web.dao;

import com.hehe.java_web.pojo.Profile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IProfileDao {
    //通过userName查询Profile
    Profile selectProfileByUserName(@Param("userName") String userName);

    //插入简介
    Integer insertProfile(Profile profile);

    //更新简介
    Integer updateProfile(Profile profile);

    //删除简介
    Integer deleteProfile(Profile profile);

    //获取用户分数
    Integer getUserScore(@Param("PUserName") String PUserName);
}
