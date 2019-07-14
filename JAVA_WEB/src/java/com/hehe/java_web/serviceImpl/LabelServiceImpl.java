package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.ILabelDao;
import com.hehe.java_web.dao.IProfileDao;
import com.hehe.java_web.dao.IUserDao;
import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "labelService")
public class LabelServiceImpl implements ILabelService {
    @Autowired
    private ILabelDao iLabelDao;

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private IProfileDao iProfileDao;

    @Override
    public boolean addLabel(Label label, String PUserName) {
            return iLabelDao.insertLabel(label) == 1;

    }

    @Override
    public boolean delLabel(Label label, String PUserName) {

            return iLabelDao.deleteLabel(label) == 1;

    }

    @Override
    public List<Label> getLabelAll() {
        return iLabelDao.selectLabelAll();
    }

    @Override
    public Integer getLabelCount() {
        return iLabelDao.selectLabelCount();
    }

    @Override
        //通过标签名获取标签
    public Label selectLabelByLName(String labelname) {
        return iLabelDao.selectLabelByLName(labelname);
    }
}
