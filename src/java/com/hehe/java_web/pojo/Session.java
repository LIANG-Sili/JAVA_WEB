package com.hehe.java_web.pojo;

public class Session {
    private int Sid;
    private String Sname;
    private int Smasterid;
    private String Sprofile;
    private String Sstatement;
    private int Stopiccount;

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public int getSmasterid() {
        return Smasterid;
    }

    public void setSmasterid(int smasterid) {
        Smasterid = smasterid;
    }

    public String getSprofile() {
        return Sprofile;
    }

    public void setSprofile(String sprofile) {
        Sprofile = sprofile;
    }

    public String getSstatement() {
        return Sstatement;
    }

    public void setSstatement(String sstatement) {
        Sstatement = sstatement;
    }

    public int getStopiccount() {
        return Stopiccount;
    }

    public void setStopiccount(int stopiccount) {
        Stopiccount = stopiccount;
    }

    public int getSclickcount() {
        return Sclickcount;
    }

    public void setSclickcount(int sclickcount) {
        Sclickcount = sclickcount;
    }

    private int Sclickcount;


}
