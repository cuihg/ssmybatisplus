package com.hy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.mapperDao.StudentMapper;
import com.hy.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService extends ServiceImpl<StudentMapper,Student> {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> selectStuAll() {
        return studentMapper.selectStuAll();
    }

    public List<Student> selectStuMethod(IPage<Student> page, Student student){
        return studentMapper.selectStuMethod(page,student);
    }

    public IPage<Student> selectStuLayUi(Integer page,Integer limit,Student student){
        IPage<Student> page1=new Page<>(page,limit);
        return studentMapper.selectStuLayUi(page1,student);
    }

    /*
        public List<Course> selectCouAll(){
            return studentMapper.selectCouAll();
        }
        public Student selectStuById(int stu_id){
            return studentMapper.selectStuById(stu_id);
        }

        public int addStu(Student student){
            return studentMapper.addStu(student);
        }

        public int upateStu(Student student){
            return studentMapper.upateStu(student);
        }

        public int deleteStu(int stu_id){
            return studentMapper.deleteStu(stu_id);
        }
    */
    public int deleteBatches(int Batches) {
        return studentMapper.deleteBatches(Batches);

    }
}