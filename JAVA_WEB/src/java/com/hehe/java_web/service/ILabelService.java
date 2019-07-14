package com.hehe.java_web.service;


import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.User;

import java.util.List;

public interface ILabelService {
    //增加标签
    public boolean addLabel(Label label, String PUserName);

    //删除标签
    public boolean delLabel(Label label, String PUserName);

    //获取所有标签
    public List<Label> getLabelAll();

    //获取标签总数
    public Integer getLabelCount();

    //通过标签名获取标签
    public Label selectLabelByLName(String labelname);
}
