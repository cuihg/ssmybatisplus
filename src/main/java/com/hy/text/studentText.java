package com.hy.text;

import com.hy.mapperDao.StudentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class studentText {
    public static void main(String[] args){
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        StudentMapper studentMapper = (StudentMapper) ApplicationContext.getBean("studentMaper");
        /*System.out.println(studentMapper.selectStuAll());*/
    }
}
