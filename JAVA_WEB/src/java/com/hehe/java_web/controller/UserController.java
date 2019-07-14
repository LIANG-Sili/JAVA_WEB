package com.hehe.java_web.controller;

import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.IUserService;
//import com.hehe.java_web.utils.CommonDate;
//import org.graalvm.compiler.nodes.calc.ObjectEqualsNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public @ResponseBody HashMap<String, Object> login( @RequestBody Map map1) {
        HashMap<String, Object> map = new HashMap<>();
        String UName = (String) map1.get("UName");
        String UPassword = (String) map1.get("UPassword");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ntime = sdf.format(new Date());
        if (userService.login(UName, UPassword)) {
            User user =  userService.getUser(UName);
                user.setURegDate(ntime);
                map.put("code", 0);
                map.put("User", user);
            } else {
                map.put("code", 1);
                map.put("User", null);
            }
            return map;
    }

    @RequestMapping("/register")
    public @ResponseBody HashMap<String, Object> register(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        String UPassword = (String) map1.get("UPassword");
        HashMap<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ntime = sdf.format(new Date());
        User user = new User(UName, UPassword, ntime);
        user.setUStatus(0);
        if (userService.addUser(user)) {
            userService.addProfile(new Profile(user.getUName()));
            map.put("code", 0);
            map.put("User", user);
        }
        else {
            map.put("code", 1);
            map.put("User", null);
        }
        return map;
    }

    @RequestMapping("/getProfile")
    public @ResponseBody HashMap<String, Object> getProfile(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        HashMap<String, Object> map = new HashMap<>();
        Profile profile = userService.getProfileByUsername(UName);
        if (profile != null) {
            map.put("code", 0);
            map.put("Profile", profile);
        }
        else {
            map.put("code", 1);
            map.put("Profile", null);
        }

        return map;
    }

    @RequestMapping("/updateProfile")
    public @ResponseBody HashMap<String, Object> updateProfile(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        String PStatement = (String) map1.get("PStatement");
        String PEmail = (String) map1.get("PEmail");
        //修改部分
        Integer PScore = (Integer) map1.get("PScore");
        HashMap<String, Object> map = new HashMap<>();
        Profile profile = new Profile(UName, PStatement, PEmail);
        profile.setPScore(PScore);
        if (userService.updateProfile(UName, profile)) {
            map.put("code", 0);
            map.put("Profile", profile);
        }
        else {
            map.put("code", 1);
            map.put("Profile", null);
        }

        return map;
    }

    @RequestMapping("/grant")
    public @ResponseBody HashMap<String, Object> grant(@RequestBody Map map1) {
        String PUserName = (String) map1.get("PUserName");
        Integer score = userService.getUserScore(PUserName);
        HashMap<String, Object> map = new HashMap<>();
        if (score == null) {
            map.put("code", 1);
            map.put("score", null);
        }
        else {
            map.put("code", 0);
            map.put("score", score);
        }
        return map;
    }

    @RequestMapping("/addProfile")
    public @ResponseBody HashMap<String, Object> addProfile(@RequestBody Map map1) {
        String PUserName = (String) map1.get("PUserName");
        String PStatement = (String) map1.get("PStatement");
        String PEmail = (String) map1.get("PEmail");
        HashMap<String, Object> map = new HashMap<>();
        User user = userService.getUser(PUserName);
        if (user == null) {
            map.put("code", 1);
            map.put("Profile", null);
        }
        else {
            Profile profile = new Profile(PUserName, PStatement, PEmail);
            userService.addProfile(profile);
            map.put("code", 0);
            map.put("Profile", profile);
        }
        return map;
    }

    @RequestMapping("/getUserByUName")
    public @ResponseBody HashMap<String, Object> getUserByUName(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        HashMap<String, Object> map = new HashMap<>();
        User user = userService.getUser(UName);
        if (user == null) {
            map.put("code", 1);
            map.put("User", null);
        }
        else {
            map.put("code", 0);
            map.put("User", user);
        }
        return map;
    }

    @RequestMapping("/getUserByUID")
    public @ResponseBody HashMap<String, Object> getUserByUID(@RequestBody Map map1) {
        Integer UID = (Integer) map1.get("UID");
        HashMap<String, Object> map = new HashMap<>();
        User user = userService.getUserByUID(UID);
        if (user == null) {
            map.put("code", 1);
            map.put("User", null);
        }
        else {
            map.put("code", 0);
            map.put("User", user);
        }
        return map;
    }

    @RequestMapping("/updateUserScore")
    public @ResponseBody HashMap<String, Object> updateUserScore(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        Integer score = (Integer) map1.get("score");
        HashMap<String, Object> map = new HashMap<>();
        Profile profile = userService.getProfileByUsername(UName);
        if (profile != null) {
            profile.setPScore(score);
            map.put("code", 0);
            map.put("Profile", profile);
        }
        else {
            map.put("code", 1);
            map.put("Profile", profile);
        }
        return map;
    }
}
