package com.hehe.java_web.controller;
import com.hehe.java_web.pojo.Post;
import com.hehe.java_web.pojo.Profile;
import com.hehe.java_web.pojo.User;
import com.hehe.java_web.service.IPostService;
import com.hehe.java_web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPostService postService;

    @RequestMapping("/getPostByUserName")
    public @ResponseBody
    HashMap<String, Object> getPostByUserName(@RequestBody Map map1) {
        String UName = (String) map1.get("UName");
        User user = userService.getUser(UName);
        HashMap<String, Object> map = new HashMap<>();
        List<Post> posts = postService.selectUserPostAll(user);
        if (posts.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        } else {
            map.put("code", 0);
            map.put("List", posts);
        }
        return map;
    }

    @RequestMapping("/getPostContent")
    public @ResponseBody
    HashMap<String, Object> getPostContent(@RequestBody Map map1) {
        String content = (String) map1.get("content");
        System.out.println(content);
        HashMap<String, Object> map = new HashMap<>();
        List<Post> posts = postService.selectPostByContent(content);
        if (posts.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        } else {
            map.put("code", 0);
            map.put("List", posts);
        }
        return map;
    }

    @RequestMapping("/getPost")
    public @ResponseBody
    HashMap<String, Object> getPost(@RequestBody Map map1) {
        Integer PID = Integer.parseInt((String) map1.get("PID"));
        HashMap<String, Object> map = new HashMap<>();
        Post post = postService.selectPostByPID(PID);
        if (post == null) {
            map.put("code", 1);
            map.put("Post", null);
        } else {
            map.put("code", 0);
            map.put("Post", post);
        }
        return map;
    }

    @RequestMapping("/addPost")
    public @ResponseBody
    HashMap<String, Object> addPost(@RequestBody Map map1) {
        String PUserName = (String) map1.get("PUserName");
        Integer pbp = (Integer) map1.get("PBelongPostID");
        Integer PBelongPostID = null;
        if (!pbp.equals(0))
            PBelongPostID = pbp;
        String PContents = (String) map1.get("PContents");
        Integer PType = (Integer) map1.get("PType");
        User user = userService.getUser(PUserName);
        Integer PBelongUserID = user.getUID();
        HashMap<String, Object> map = new HashMap<>();
        Post post = new Post(PBelongPostID, PContents, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), PType, PBelongUserID);
        post.setPFlag(0);
        System.out.println(post);
        System.out.println(PUserName);
        if (postService.addPost(post, PUserName)) {
            map.put("code", 0);
            map.put("Post", post);
        } else {
            map.put("code", 1);
            map.put("Post", null);
        }
        return map;
    }

    @RequestMapping("/delPost")
    public @ResponseBody
    HashMap<String, Object> delPost(@RequestBody Map map1) {
        Integer PID = (Integer) map1.get("PID");
        String PUserName = (String) map1.get("PUserName");
        HashMap<String, Object> map = new HashMap<>();
        Post post = postService.selectPostByPID(PID);
        if (postService.delPost(post, PUserName)) {
            map.put("code", 0);
            map.put("Post", post);
        } else {
            map.put("code", 1);
            map.put("Post", null);
        }
        return map;
    }

    @RequestMapping("/updatePost")
    public @ResponseBody
    HashMap<String, Object> updatePost(@RequestBody Map map1) {
        Integer PID = (Integer) map1.get("PID");
        String UName = (String) map1.get("UName");
        String PContents = (String) map1.get("PContents");
        Integer PFlag = Integer.parseInt((String) map1.get("PFlag"));
        Integer PType = Integer.parseInt((String) map1.get("PType"));
        HashMap<String, Object> map = new HashMap<>();
        Post post = postService.selectPostByPID(PID);
        User user = userService.getUser(UName);
        post.setPContents(PContents);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ntime = sdf.format(new Date());
        post.setPTimes(ntime);
        post.setPFlag(PFlag);
        post.setPType(PType);
        if (postService.updatePost(post, user)) {
            map.put("code", 0);
            map.put("Post", post);
        } else {
            map.put("code", 1);
            map.put("Post", null);
        }
        return map;
    }

    //获取所有贴子
    @RequestMapping("/selectPostAll")
    public @ResponseBody
    HashMap<String, Object> selectPostAll() {
        HashMap<String, Object> map = new HashMap<>();
        List<Post> posts = postService.selectPostAll();
        if (posts.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        } else {
            map.put("code", 0);
            map.put("List", posts);
        }
        return map;
    }

    //获取某个用户的所有贴子
    @RequestMapping("/selectUserPostAll")
    public @ResponseBody
    HashMap<String, Object> selectUserPostAll(@RequestBody Map map1) {
        HashMap<String, Object> map = new HashMap<>();
        String UName = (String) map1.get("UName");
        List<Post> posts = postService.selectUserPostAll(userService.getUser(UName));
        if (posts.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        } else {
            map.put("code", 0);
            map.put("List", posts);
        }
        return map;
    }

    //获取某个用户的所有回帖
    @RequestMapping("/selectUserReplyAll")
    public @ResponseBody
    HashMap<String, Object> selectUserReplyAll(@RequestBody Map map1) {
        HashMap<String, Object> map = new HashMap<>();
        String UName = (String) map1.get("UName");
        List<Post> posts = postService.selectUserReplyAll(userService.getUser(UName));
        if (posts.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        } else {
            map.put("code", 0);
            map.put("List", posts);
        }
        return map;
    }

    //获取该贴子所有回帖
    @RequestMapping("/selectPostReplyAll")
    public @ResponseBody
    HashMap<String, Object> selectPostReplyAll(@RequestBody Map map1) {
        HashMap<String, Object> map = new HashMap<>();
        Integer PID = Integer.parseInt((String) map1.get("PID"));
        List<Post> posts = postService.selectPostReplyAll(PID);
        if (posts.isEmpty()) {
            map.put("code", 1);
            map.put("List", null);
        } else {
            map.put("code", 0);
            map.put("List", posts);
        }
        return map;
    }

    //获取是否能删除
    @RequestMapping("/checkCanDel")
    public @ResponseBody
    HashMap<String, Object> checkCanDel(@RequestBody Map map1) {
        HashMap<String, Object> map = new HashMap<>();
        String username = (String) map1.get("UName");
        Integer PID = (Integer) map1.get("PID");
        Post post = postService.selectPostByPID(PID);
        Profile profile = userService.getProfileByUsername(username);
        if(profile!=null && post != null)
        {
            if(profile.getPScore()>=2)
            {
                map.put("code",0);
                return map;
            }
            else if(profile.getPScore()==1)
            {
                if(profile.getPUserName().equals(username))
                {
                    map.put("code",0);
                    return map;
                }
            }
        }
        map.put("code",1);
        return map;
    }
}
