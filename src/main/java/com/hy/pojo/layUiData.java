package com.hy.pojo;

import java.util.Arrays;
import java.util.List;

public class layUiData {
    private Integer Code;
    private String Msg;
    private Integer Count;
    private List<Student> Data;

    public List<Student> getData() {
        return Data;
    }

    public void setData(List<Student> data) {
        Data = data;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    @Override
    public String toString() {
        return "layUiData{" +
                "Code=" + Code +
                ", Msg='" + Msg + '\'' +
                ", Count=" + Count +
                ", Data=" + Data +
                '}';
    }
}
