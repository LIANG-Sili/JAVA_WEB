package com.hehe.java_web.pojo;

import org.springframework.stereotype.Repository;

@Repository(value = "post")
public class Post {
    private Integer PID;
    private Integer PBelongPostID;
    private String PContents;
    private String PTimes;
    private Integer PFlag;
    private Integer PType;
    private Integer PBelongUserID;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public Integer getPBelongPostID() {
        return PBelongPostID;
    }

    public void setPBelongPostID(Integer PBelongPostID) {
        this.PBelongPostID = PBelongPostID;
    }

    public String getPContents() {
        return PContents;
    }

    public void setPContents(String PContents) {
        this.PContents = PContents;
    }

    public String getPTimes() {
        return PTimes;
    }

    public void setPTimes(String PTimes) {
        this.PTimes = PTimes;
    }

    public Integer getPFlag() {
        return PFlag;
    }

    public void setPFlag(Integer PFlag) {
        this.PFlag = PFlag;
    }

    public Integer getPType() {
        return PType;
    }

    public void setPType(Integer PType) {
        this.PType = PType;
    }

    public Integer getPBelongUserID() {
        return PBelongUserID;
    }

    public void setPBelongUserID(Integer PBelongUserID) {
        this.PBelongUserID = PBelongUserID;
    }

    public Post() {
    }

    public Post(Integer PBelongPostID, String PContents, String PTimes, Integer PType, Integer PBelongUserID) {
        this.PBelongPostID = PBelongPostID;
        this.PContents = PContents;
        this.PTimes = PTimes;
        this.PType = PType;
        this.PBelongUserID = PBelongUserID;
    }

    @Override
    public String toString() {
        return "Post{" +
                "PID=" + PID +
                ", PBelongPostID=" + PBelongPostID +
                ", PContents='" + PContents + '\'' +
                ", PTimes='" + PTimes + '\'' +
                ", PFlag=" + PFlag +
                ", PType=" + PType +
                ", PBelongUserID=" + PBelongUserID +
                '}';
    }
}
