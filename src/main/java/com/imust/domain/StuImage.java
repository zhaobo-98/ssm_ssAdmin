package com.imust.domain;

import java.io.Serializable;

public class StuImage implements Serializable {
    private Integer imgId;
    private String imgPath;
    private Student student;

    @Override
    public String toString() {
        return "StuImage{" +
                "imgId=" + imgId +
                ", imgPath='" + imgPath + '\'' +
                ", student=" + student +
                '}';
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
