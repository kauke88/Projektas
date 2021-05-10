package lt.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.mybatis.model.Course;
import lt.mybatis.dao.CourseMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CoursesMyBatis {

    @Inject
    private CourseMapper courseMapper;

    @Getter @Setter
    private Course courseToCreate = new Course();

    @Getter
    private List<Course> allCourses;

    @PostConstruct
    public void init(){
        loadAllTeams();
    }

    @Transactional
    public String deleteCourse(lt.mybatis.model.Course courseToDelete){
        this.courseMapper.deleteByPrimaryKey(courseToDelete.getId());
        return "/mybatis/index?faces-redirect=true";
    }
    @Transactional
    public String createCourse(){
        this.courseMapper.insert(courseToCreate);
        return "/mybatis/index?faces-redirect=true";
    }
    private void loadAllTeams(){
        this.allCourses = courseMapper.selectAll();
    }
}