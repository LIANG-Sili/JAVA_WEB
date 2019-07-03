package com.hehe.java_web.serviceImpl;

import com.hehe.java_web.dao.ILabelDao;
import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "labelService")
public class LabelServiceImpl implements ILabelService {
    @Autowired
    private ILabelDao iLabelDao;

    @Override
    public boolean addLabel(Label label) {
        return iLabelDao.insertLabel(label) == 1;
    }

    @Override
    public boolean delLabel(Label label) {
        return iLabelDao.deleteLabel(label) == 1;
    }

    @Override
    public List<Label> getLabelAll(int offset, int limit) {
        return iLabelDao.selectLabelAll(offset,limit);
    }

    @Override
    public Integer getLabelCount() {
        return iLabelDao.selectLabelCount();
    }
}
