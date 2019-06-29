package com.hehe.java_web.pojo;

import java.sql.Timestamp;

public class User {
    private int Uid;
    private String Uname;
    private String Upassword;
    private String Uemail;
    private String Ubirthday;
    private int Usex;
    private String Uhead;
    private String Ustatement;
    private Timestamp Uregdate;
    private int Ustate;
    private int Upoint;
    private int Uisectioner;

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    public String getUbirthday() {
        return Ubirthday;
    }

    public void setUbirthday(String ubirthday) {
        Ubirthday = ubirthday;
    }

    public int getUsex() {
        return Usex;
    }

    public void setUsex(int usex) {
        Usex = usex;
    }

    public String getUhead() {
        return Uhead;
    }

    public void setUhead(String uhead) {
        Uhead = uhead;
    }

    public String getUstatement() {
        return Ustatement;
    }

    public void setUstatement(String ustatement) {
        Ustatement = ustatement;
    }

    public Timestamp getUregdate() {
        return Uregdate;
    }

    public void setUregdate(Timestamp uregdate) {
        Uregdate = uregdate;
    }

    public int getUstate() {
        return Ustate;
    }

    public void setUstate(int ustate) {
        Ustate = ustate;
    }

    public int getUpoint() {
        return Upoint;
    }

    public void setUpoint(int upoint) {
        Upoint = upoint;
    }

    public int getUisectioner() {
        return Uisectioner;
    }

    public void setUisectioner(int uisectioner) {
        Uisectioner = uisectioner;
    }
}
