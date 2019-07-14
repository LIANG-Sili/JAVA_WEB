package com.hehe.java_web.util;

import java.util.HashMap;

public class SessionPool {
    static HashMap<String,String> pool;
    public static Boolean isLogin(String username, String token) {
         if(pool.containsKey(username)){
             return pool.get(username).equals(token);
         }else {
             return false;
         }
    }
    public static String login(String username){
        String token = ((Double)Math.random()).toString();
        pool.put(username, token);
        return token;
    }
    public static Boolean check(String username, String token) {
        return pool.get(username).equals(token);
    }
    public static Boolean logout(String username,String token) {
        if (pool.get(username).equals(token)) {
            pool.remove(username);
            return true;
        } else {
            return false;
        }
    }
}
