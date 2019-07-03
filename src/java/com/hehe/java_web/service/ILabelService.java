package com.hehe.java_web.service;

import com.hehe.java_web.pojo.Label;

import java.util.List;

public interface ILabelService {
    //增加标签
    public boolean addLabel(Label label);

    //删除标签
    public boolean delLabel(Label label);

    //获取所有标签
    public List<Label> getLabelAll(int offset,int limit);

    //获取标签总数
    public Integer getLabelCount();
}
