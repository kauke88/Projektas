package lt.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.entities.Course;
import lt.entities.Student;
import lt.persistence.CoursesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Courses {

    @Inject
    private CoursesDAO coursesDAO;

    @Getter @Setter
    private Course courseToCreate = new Course();

    @Getter
    private List<Course> allCourses;

    @PostConstruct
    public void init(){
        loadAllCourses();
    }

    @Transactional
    public String createCourse(){
        this.coursesDAO.persist(courseToCreate);
        return "index?faces-redirect=true";
    }
    @Transactional
    public String deleteCourse(Course courseToDelete){
        this.coursesDAO.delete(courseToDelete);
        return "/index?faces-redirect=true";
    }
    private void loadAllCourses(){
        this.allCourses = coursesDAO.loadAll();
    }
}