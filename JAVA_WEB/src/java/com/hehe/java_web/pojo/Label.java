package com.hehe.java_web.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
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

    public Label(String LName) {
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
