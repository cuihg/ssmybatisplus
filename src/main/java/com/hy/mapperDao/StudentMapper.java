package com.hy.mapperDao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.DynamicSQL.StuDynamicStatement;
import com.hy.pojo.Course;
import com.hy.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    @Results({@Result(column = "cname",property = "course.cname")})
    @Select("select s.stu_id,s.name,s.sex,s.birthday,c.cname,s.specialty,s.image,s.scholarship " +
            "from student s left join course c on s.class_id=c.class_id")
    List<Student> selectStuAll();

    @Results({@Result(column = "cname",property = "course.cname")})
    @SelectProvider(type = StuDynamicStatement.class,method = "StudentConditionQuery")
    List<Student> selectStuMethod(IPage<Student> page,@Param("stu") Student student);


    @Results({@Result(column = "cname",property = "course.cname")})
    @SelectProvider(type = StuDynamicStatement.class,method = "StudentConditionQuery")
    IPage<Student> selectStuLayUi(IPage<Student> page,@Param("stu")Student student);

    /*@Select("select * from course")
    public List<Course> selectCouAll();
    @Select("select * from student where stu_id=#{stu_id}")
    public Student selectStuById(int stu_id);

    @SelectKey(statement = "select LAST_INSERT_ID()",before = true,resultType = int.class,keyProperty = "stu_id")
    @Insert("insert into student values(#{stu_id},#{name},#{sex},#{birthday},#{class_id},#{specialty},#{image},#{scholarship})")
    public int addStu(Student student);

    @Update("update student set name=#{name},sex=#{sex},birthday=#{birthday},class_id=#{class_id},specialty=#{specialty},image=#{image},scholarship=#{scholarship} where stu_id=#{stu_id}")
    public int upateStu(Student student);

    @Delete("delete from student where stu_id=#{stu_id}")
    public int deleteStu(int stu_id);
*/
    @Delete("delete from student where stu_id=#{stu_id}")
    public int deleteBatches(int Batches);
}
