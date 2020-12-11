package com.hy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "course")
public class Course {
    @TableId(value = "cid",type = IdType.AUTO)
    private int cid;

    @TableField("class_id")
    private String classId;

    private String cname;

    private String credit;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }


    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", classId='" + classId + '\'' +
                ", cname='" + cname + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
