package com.hehe.java_web.pojo;

import org.springframework.stereotype.Repository;

@Repository(value = "label")
public class Label {
    private Integer LID;
    private String LName;

    public Integer getLID() {
        return LID;
    }

    public void setLID(Integer LID) {
        this.LID = LID;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public Label() {
    }

    public Label(Integer LID, String LName) {
        this.LID = LID;
        this.LName = LName;
    }

    @Override
    public String toString() {
        return "Label{" +
                "LID=" + LID +
                ", LName='" + LName + '\'' +
                '}';
    }
}
