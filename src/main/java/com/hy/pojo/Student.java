package com.hy.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.sql.Date;

@TableName(value = "student")
public class Student {
    @TableId(value = "stu_id",type = IdType.AUTO)
    private int stuId;

    private String name;

    private String sex;

    private Date birthday;

    @TableField(exist = false)
    private Course course;

    private String class_id;

    private String specialty;

    private String image;

    private String scholarship;


    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", course=" + course +
                ", class_id='" + class_id + '\'' +
                ", specialty='" + specialty + '\'' +
                ", image='" + image + '\'' +
                ", scholarship='" + scholarship + '\'' +
                '}';
    }

}
