package com.hehe.java_web.pojo;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

@Repository(value = "user")
public class User {
    private Integer UID;
    private String UName;
    private String UPassword;
    private String URegDate;
    private Integer UStatus;

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getURegDate() {
        return URegDate;
    }

    public void setURegDate(String URegDate) {
        this.URegDate = URegDate;
    }

    public Integer getUStatus() {
        return UStatus;
    }

    public void setUStatus(Integer UStatus) {
        this.UStatus = UStatus;
    }

    public User() {
        super();
    }

    public User(String UName, String UPassword, String URegDate) {
        this.UName = UName;
        this.UPassword = UPassword;
        this.URegDate = URegDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "UID=" + UID +
                ", UName='" + UName + '\'' +
                ", UPassword='" + UPassword + '\'' +
                ", URegDate='" + URegDate + '\'' +
                ", UStatus=" + UStatus +
                '}';
    }

}
