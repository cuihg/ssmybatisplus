import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.mapperDao.CourseMapper;
import com.hy.mapperDao.StudentMapper;
import com.hy.pojo.Course;
import com.hy.pojo.Student;
import com.hy.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class Demo {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void demo() {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("class_id","0405班");
        Course course = courseMapper.selectOne(courseQueryWrapper);
        System.out.println(course);
//        list.forEach(System.out::println);
    }
}
