package com.hy.controllar;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.mapperDao.CourseMapper;
import com.hy.pojo.Course;
import com.hy.pojo.Student;
import com.hy.pojo.layUiData;
import com.hy.service.CourseService;
import com.hy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("selectStudentMethod")
    public String selectStudentMethod(Model model,int page,Student student){
        IPage<Student> pageList=new Page<Student>(page,5);
        List<Student> list=studentService.selectStuMethod(pageList,student);
        model.addAttribute("list",list);
        return "studentJsp";
    }

    /*根据id查询student表的stu_id，跳updateStudent.jsp*/
    @RequestMapping("selectStudentById")
    public String selectStudentById(Model model, int stu_id){
        Student selectStuById= (Student) studentService.getById(stu_id);
        model.addAttribute("selectStuById",selectStuById);
        return "updateStudent";
    }

    /*添加student表*/
    @RequestMapping("addStudent")
    public String addStudent(@RequestParam("img") MultipartFile pictureFile, Student student) throws IOException {
        //设置图片名称，不能重复，可以使用UUID
        String picName= UUID.randomUUID().toString();
        //获取文件名
        String oriName=pictureFile.getOriginalFilename();
        //获取图片后缀
        String extName=oriName.substring(oriName.lastIndexOf("."));
        //开始上传
        pictureFile.transferTo(new File("E:/apache-tomcat-8.0.48/webapps/image2.0/" + picName + extName));
        student.setImage(picName + extName);
        studentService.save(student);
        return "selectStudentMethod";
    }

    /*修改student表数据*/
    @RequestMapping("upateStudent")
    public String upateStudent(@RequestParam("img") MultipartFile pictureFile,Model model,Student student) throws IOException {
            //设置图片名称，不能重复，可以使用UUID
            String picName= UUID.randomUUID().toString();
            //获取文件名
            String oriName=pictureFile.getOriginalFilename();
            //开始上传
        if(oriName!=null&&oriName!=""){
            //获取图片后缀
            String extName=oriName.substring(oriName.lastIndexOf("."));
            pictureFile.transferTo(new File("E:/apache-tomcat-8.0.48/webapps/image2.0/" + picName + extName));
            student.setImage(picName + extName);
        }
        studentService.updateById(student);
        return "selectStudentMethod";
    }

    /*查询course表所有*/
    @RequestMapping("/selectCourseAllLayUi")
    @ResponseBody
    public List<Course> selectCourseAll(){
        List<Course> selectCourseAll=courseService.list(null);
        return selectCourseAll;
    }

    @RequestMapping("selectStudentLayUi")
    @ResponseBody
    public layUiData selectStudentLayUi(Integer page,Integer limit, Student student){
        IPage<Student> list=studentService.selectStuLayUi( 1,5,student);
        layUiData layUiData=new layUiData();
        layUiData.setCode(0);
        layUiData.setMsg("");
        layUiData.setCount(20);
        layUiData.setData(list.getRecords());
        return layUiData;
    }

    /*根据id删除student表数据*/
    @RequestMapping("deleteStudentLayUi")
    @ResponseBody
    public boolean deleteStudentLayUi(int stu_id){
        studentService.removeById(stu_id);
        return true;
    }

    /*批量删除*/
    @RequestMapping("/deleteBatchesLayUi")
    @ResponseBody
    public boolean deleteBatchesLayUi(String stu_id){
        try {
            studentService.removeByIds(Arrays.asList(stu_id.split(",")));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/saveStudentLayUi")
    @ResponseBody
    public boolean save(@RequestBody Student student){
        try {
            studentService.saveOrUpdate(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/selectStudentByIdLayUi")
    @ResponseBody
    public Student selectStudentById(Integer stu_id){
        return studentService.getById(stu_id);
    }

    @RequestMapping("/deleteStudentAllLayUi")
    @ResponseBody
    public boolean deleteStudentAllLayUi(String ids){
        try {
            studentService.removeByIds(Arrays.asList(ids.split(",")));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
