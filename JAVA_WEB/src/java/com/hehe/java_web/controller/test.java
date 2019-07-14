package com.hehe.java_web.controller;

import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class test {
    @RequestMapping("/test1")
    public @ResponseBody
    HashMap<String, Object> test1(@RequestBody Map map1) {
        HashMap<String, Object> map = new HashMap<>();
//            Post post = new Post('');
        System.out.println(map1);
        System.out.println(map1.get("UName"));
        System.out.println(map1.get("UPassword"));
            User user = new User("21","12","23");
            map.put("user", user);
//            map.put("Post", post);
        return map;
    }
}
