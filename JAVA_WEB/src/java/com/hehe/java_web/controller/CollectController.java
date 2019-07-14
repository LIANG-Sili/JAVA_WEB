package com.hehe.java_web.controller;

import com.hehe.java_web.pojo.Label;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.ICollectService;
import com.hehe.java_web.service.ILabelService;
import com.hehe.java_web.service.IPostService;
import com.hehe.java_web.service.IUserService;
//import com.sun.org.apache.bcel.internal.generic.IUSHR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import sun.rmi.server.InactiveGroupException;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private IPostService postService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ILabelService labelService;

    @Autowired
    private ICollectService collectService;

    @RequestMapping("/addPostLabel")
    public @ResponseBody HashMap<String, Object> addPostLabel(@RequestBody Map map1) {
        Integer PID = (Integer) map1.get("PID");
        String LName = (String) map1.get("LName");
        HashMap<String, Object> map = new HashMap<>();
        Post post = postService.selectPostByPID(PID);
        Label label = labelService.selectLabelByLName(LName);
        if (collectService.insertPostBelongLabel(post, label)) {
            map.put("code", 0);
            map.put("Post", post);
            map.put("Label", label);
        }
        else {
            map.put("code", 1);
            map.put("Post", post);
            map.put("Label", label);
        }
        return map;
    }

    @RequestMapping("/delPostLabel")
    public @ResponseBody HashMap<String, Object> delPostLabel(@RequestBody Map map1) {
        Integer PID = (Integer) map1.get("PID");
        String LName = (String) map1.get("LName");
        HashMap<String, Object> map = new HashMap<>();
        Post post = postService.selectPostByPID(PID);
        Label label = labelService.selectLabelByLName(LName);
        System.out.println(post);
        System.out.println(label);
        if (collectService.deletePostBelongLabel(post, label)) {
            map.put("code", 0);
            map.put("Post", post);
            map.put("Label", label);
        }
        else {
            map.put("code", 1);
            map.put("Post", post);
            map.put("Label", label);
        }
        return map;
    }

    @RequestMapping("/addUserCollectUser")
    public @ResponseBody HashMap<String, Object> addUserCollectUser(@RequestBody Map map1) {
        String UName1 = (String) map1.get("UName1");
        String UName2 = (String) map1.get("UName2");
        HashMap<String, Object> map = new HashMap<>();
        User user1 = userService.getUser(UName1);
        User user2 = userService.getUser(UName2);
        if (collectService.userCollectUser(UName1, UName2)) {
            map.put("code", 0);
            map.put("User1", user1);
            map.put("User2", user2);
        }
        else {
            map.put("code", 1);
            map.put("User1", user1);
            map.put("User2", user2);
        }
        return map;
    }

    @RequestMapping("/delUserCollectUser")
    public @ResponseBody HashMap<String, Object> delUserCollectUser(@RequestBody Map map1) {
        String UName1 = (String) map1.get("UName1");
        String UName2 = (String) map1.get("UName2");
        HashMap<String, Object> map = new HashMap<>();
        User user1 = userService.getUser(UName1);
        User user2 = userService.getUser(UName2);
        if (collectService.userNotCollectUser(UName1, UName2)) {
            map.put("code", 0);
            map.put("User1", user1);
            map.put("User2", user2);
        }
        else {
            map.put("code", 1);
            map.put("User1", user1);
            map.put("User2", user2);
        }
        return map;
    }

    @RequestMapping("/addUserCollectPost")
    public @ResponseBody HashMap<String, Object> addUserCollectPost(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        Integer PID = (Integer) map1.get("PID");
        HashMap<String, Object> map = new HashMap<>();
        User user1 = userService.getUser(UName);
        Post post = postService.selectPostByPID(PID);
        if (collectService.userCollectPost(UName, PID)) {
            map.put("code", 0);
            map.put("User", user1);
            map.put("Post", post);
        }
        else {
            map.put("code", 1);
            map.put("User", user1);
            map.put("Post", post);
        }
        return map;
    }

    @RequestMapping("/delUserCollectPost")
    public @ResponseBody HashMap<String, Object> delUserCollectPost(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        Integer PID = (Integer)map1.get("PID");
        HashMap<String, Object> map = new HashMap<>();
        User user1 = userService.getUser(UName);
        Post post = postService.selectPostByPID(PID);
        if (collectService.userNotCollectPost(UName, PID)) {
            map.put("code", 0);
            map.put("User", user1);
            map.put("Post", post);
        }
        else {
            map.put("code", 1);
            map.put("User", user1);
            map.put("Post", post);
        }
        return map;
    }

    @RequestMapping("/addUserCollectLabel")
    public @ResponseBody HashMap<String, Object> addUserCollectLabel(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        String LName = (String) map1.get("LName");
        HashMap<String, Object> map = new HashMap<>();
        User user1 = userService.getUser(UName);
        Label label = labelService.selectLabelByLName(LName);
        if (collectService.userCollectLabel(UName, LName)) {
            map.put("code", 0);
            map.put("User", user1);
            map.put("Label", label);
        }
        else {
            map.put("code", 1);
            map.put("User", user1);
            map.put("Label", label);
        }
        return map;
    }

    @RequestMapping("/delUserCollectLabel")
    public @ResponseBody HashMap<String, Object> delUserCollectLabel(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        String LName = (String) map1.get("LName");
        HashMap<String, Object> map = new HashMap<>();
        User user1 = userService.getUser(UName);
        Label label = labelService.selectLabelByLName(LName);
        if (collectService.userNotCollectLabel(UName, LName)) {
            map.put("code", 0);
            map.put("User", user1);
            map.put("Label", label);
        }
        else {
            map.put("code", 1);
            map.put("User", user1);
            map.put("Label", label);
        }
        return map;
    }

    @RequestMapping("/getUserCollectLabel")
    public @ResponseBody HashMap<String, Object> getUserCollectLabel(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        HashMap<String, Object> map = new HashMap<>();
        List<Label> labels = collectService.getUserCollectLabel(UName);
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

    @RequestMapping("/getUserCollectPost")
    public @ResponseBody HashMap<String, Object> getUserCollectPost(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        HashMap<String, Object> map = new HashMap<>();
        List<Post> posts = collectService.getUserCollectPost(UName);
        if (posts.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        }
        else {
            map.put("code", 0);
            map.put("List", posts);
        }
        return map;
    }

    @RequestMapping("/getUserCollectUser")
    public @ResponseBody HashMap<String, Object> getUserCollectUser(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        HashMap<String, Object> map = new HashMap<>();
        List<User> users = collectService.getUserCollectUser(UName);
        if (users.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        }
        else {
            map.put("code", 0);
            map.put("List", users);
        }
        return map;
    }

    @RequestMapping("/getUserCollectLabelCount")
    public @ResponseBody HashMap<String, Object> getUserCollectLabelCount(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        Integer count = collectService.selectUserCollectLabelCount(userService.getUser(UName).getUID());
        HashMap<String, Object> map = new HashMap<>();
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

    @RequestMapping("/getUserCollectPostCount")
    public @ResponseBody HashMap<String, Object> getUserCollectPostCount(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        Integer count = collectService.getUserCollectPost(UName).size();
        HashMap<String, Object> map = new HashMap<>();
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

    @RequestMapping("/getUserCollectUserCount")
    public @ResponseBody HashMap<String, Object> getUserCollectUserCount(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        Integer count = collectService.getUserCollectUser(UName).size();
        HashMap<String, Object> map = new HashMap<>();
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
