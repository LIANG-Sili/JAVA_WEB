package com.hehe.java_web.pojo;

import java.sql.Timestamp;

public class Topic {
    private int Tid;
    private int Tsid;
    private int Tuid;
    private int Treplycount;
    private String Ttopic;
    private String Tcontents;
    private Timestamp Ttimes;
    private int Tclickcount;
    private int Tflag;
    private int Tlastreplyuserid;
    private Timestamp Tlastreplytime;

    public int getTid() {
        return Tid;
    }

    public void setTid(int tid) {
        Tid = tid;
    }

    public int getTsid() {
        return Tsid;
    }

    public void setTsid(int tsid) {
        Tsid = tsid;
    }

    public int getTuid() {
        return Tuid;
    }

    public void setTuid(int tuid) {
        Tuid = tuid;
    }

    public int getTreplycount() {
        return Treplycount;
    }

    public void setTreplycount(int treplycount) {
        Treplycount = treplycount;
    }

    public String getTtopic() {
        return Ttopic;
    }

    public void setTtopic(String ttopic) {
        Ttopic = ttopic;
    }

    public String getTcontents() {
        return Tcontents;
    }

    public void setTcontents(String tcontents) {
        Tcontents = tcontents;
    }

    public Timestamp getTtimes() {
        return Ttimes;
    }

    public void setTtimes(Timestamp ttimes) {
        Ttimes = ttimes;
    }

    public int getTclickcount() {
        return Tclickcount;
    }

    public void setTclickcount(int tclickcount) {
        Tclickcount = tclickcount;
    }

    public int getTflag() {
        return Tflag;
    }

    public void setTflag(int tflag) {
        Tflag = tflag;
    }

    public int getTlastreplyuserid() {
        return Tlastreplyuserid;
    }

    public void setTlastreplyuserid(int tlastreplyuserid) {
        Tlastreplyuserid = tlastreplyuserid;
    }

    public Timestamp getTlastreplytime() {
        return Tlastreplytime;
    }

    public void setTlastreplytime(Timestamp tlastreplytime) {
        Tlastreplytime = tlastreplytime;
    }
}
