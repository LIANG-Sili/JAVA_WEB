package com.hehe.java_web.pojo;

import java.sql.Timestamp;

public class Reply {
    private int Rid;
    private int Rtid;
    private int Rsid;
    private int Ruid;
    private String Rcontent;
    private Timestamp Rtime;

    public int getRid() {
        return Rid;
    }

    public void setRid(int rid) {
        Rid = rid;
    }

    public int getRtid() {
        return Rtid;
    }

    public void setRtid(int rtid) {
        Rtid = rtid;
    }

    public int getRsid() {
        return Rsid;
    }

    public void setRsid(int rsid) {
        Rsid = rsid;
    }

    public int getRuid() {
        return Ruid;
    }

    public void setRuid(int ruid) {
        Ruid = ruid;
    }

    public String getRcontent() {
        return Rcontent;
    }

    public void setRcontent(String rcontent) {
        Rcontent = rcontent;
    }

    public Timestamp getRtime() {
        return Rtime;
    }

    public void setRtime(Timestamp rtime) {
        Rtime = rtime;
    }
}
