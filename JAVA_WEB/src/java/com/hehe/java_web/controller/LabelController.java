package com.hehe.java_web.controller;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.ILabelService;
import com.hehe.java_web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private ILabelService labelService;

    @Autowired
    private IUserService userService;

    /*
    增加label
     */
    @RequestMapping("/addLabel")
    public @ResponseBody HashMap<String, Object> addLabel(@RequestBody Map map1) {
        String PUserName = (String) map1.get("PUserName");
        String LName = (String) map1.get("LName");
        HashMap<String, Object> map = new HashMap();
        Label label = new Label(LName);
        if (labelService.addLabel(label, PUserName)) {
            label = labelService.selectLabelByLName(LName);
            map.put("code", 0);
            map.put("Label", label);
        }
        else {
            map.put("code", 1);
            map.put("Label", null);
        }
        return map;
    }

    /*
    删除Label
     */
    @RequestMapping("/delLabel")
    public @ResponseBody HashMap<String, Object> delLabel(@RequestBody Map map1) {
        String PUserName = (String) map1.get("PUserName");
        String LName = (String) map1.get("LName");
        HashMap<String, Object> map = new HashMap<>();
        Label label = labelService.selectLabelByLName(LName);
        if (labelService.delLabel(label, PUserName)) {
            map.put("code", 0);
            map.put("Label", label);
        }
        else {
            map.put("code", 1);
            map.put("Label", null);
        }
        return map;
    }

    @RequestMapping("/selectLabelAll")
    public @ResponseBody HashMap<String, Object> selectLabelAll() {
        HashMap<String, Object> map = new HashMap<>();
        List<Label> labels = labelService.getLabelAll();
        if (labels.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        }
        else {
            map.put("code", 0);
            map.put("List", labels);
        }
        return map;
    }

    @RequestMapping("/getLabelCount")
    public @ResponseBody HashMap<String, Object> getLabelCount() {
        HashMap<String, Object> map = new HashMap<>();
        Integer count = labelService.getLabelCount();
        if (count == 0) {
            map.put("code", 1);
            map.put("Count", null);
        }
        else {
            map.put("code", 0);
            map.put("Count", count);
        }
        return map;
    }
}
