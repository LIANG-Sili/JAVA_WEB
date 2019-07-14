package com.hehe.java_web.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Component
public class Profile {
    private String PUserName;
    private String PStatement;
    private String PEmail;
    private Integer PScore;

    public String getPUserName() {
        return PUserName;
    }

    public void setPUserName(String PUserName) {
        this.PUserName = PUserName;
    }

    public String getPStatement() {
        return PStatement;
    }

    public void setPStatement(String PStatement) {
        this.PStatement = PStatement;
    }

    public String getPEmail() {
        return PEmail;
    }

    public void setPEmail(String PEmail) {
        this.PEmail = PEmail;
    }

    public Integer getPScore() {
        return PScore;
    }

    public void setPScore(Integer PScore) {
        this.PScore = PScore;
    }

    public Profile(){
        super();
    }

    public Profile(String PUserName) {
        this.PUserName = PUserName;
    }

    public Profile(String PUserName, String PStatement, String PEmail) {
        this.PUserName = PUserName;
        this.PStatement = PStatement;
        this.PEmail = PEmail;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "PUserName='" + PUserName + '\'' +
                ", PStatement='" + PStatement + '\'' +
                ", PEmail='" + PEmail + '\'' +
                ", PScore=" + PScore +
                '}';
    }
}
