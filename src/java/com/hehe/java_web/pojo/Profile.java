package com.hehe.java_web.pojo;

import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository(value = "profile")
public class Profile {
    private String PUserName;
    private byte[] PHead;
    private Integer PGender;
    private String PStatement;
    private String PEmail;
    private Integer PScore;

    public String getPUserName() {
        return PUserName;
    }

    public void setPUserName(String PUserName) {
        this.PUserName = PUserName;
    }

    public byte[] getPHead() {
        return PHead;
    }

    public void setPHead(byte[] PHead) {
        this.PHead = PHead;
    }

    public Integer getPGender() {
        return PGender;
    }

    public void setPGender(Integer PGender) {
        this.PGender = PGender;
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
    public Profile(byte[] PHead, int PGender, String PStatement, String PEmail, int PScore) {
        this.PHead = PHead;
        this.PGender = PGender;
        this.PStatement = PStatement;
        this.PEmail = PEmail;
        this.PScore = PScore;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "PUserName='" + PUserName + '\'' +
                ", PHead=" + Arrays.toString(PHead) +
                ", PGender=" + PGender +
                ", PStatement='" + PStatement + '\'' +
                ", PEmail='" + PEmail + '\'' +
                ", PScore=" + PScore +
                '}';
    }
}
