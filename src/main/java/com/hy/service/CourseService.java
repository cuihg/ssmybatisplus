package com.hy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.mapperDao.CourseMapper;
import com.hy.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService extends ServiceImpl<CourseMapper, Course> {
    @Autowired
    private CourseMapper courseMapper;
}
