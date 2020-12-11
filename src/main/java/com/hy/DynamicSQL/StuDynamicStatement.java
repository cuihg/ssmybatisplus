package com.hy.DynamicSQL;

import com.hy.pojo.Student;
import org.apache.ibatis.annotations.Param;

public class StuDynamicStatement {
    public String StudentConditionQuery(@Param("stu") Student student){
        StringBuffer sql=new StringBuffer("select s.stu_id,s.name,s.sex,s.birthday,c.cname,s.specialty,s.image,s.scholarship from Student s,Course c where s.class_id=c.class_id");
        if(student!=null){
            if(student.getName()!=null && student.getName()!=""){
                sql.append(" and s.name=#{stu.name}");
            }
            if(student.getSpecialty()!=null && student.getSpecialty()!=""){
                sql.append(" and s.specialty=#{stu.specialty}");
            }
            if(student.getSex()!=null && student.getSex()!=""){
                sql.append(" and s.sex=#{stu.sex}");
            }
            if(student.getClass_id()!=null && student.getClass_id()!=""){
                sql.append(" and c.class_id=#{stu.class_id}");
            }
        }
        return sql.toString();
    }
}
