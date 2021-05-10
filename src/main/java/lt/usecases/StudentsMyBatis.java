package lt.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.mybatis.dao.CarMapper;
import lt.mybatis.dao.CourseMapper;
import lt.mybatis.dao.StudentCourseMapper;
import lt.mybatis.dao.StudentMapper;
import lt.mybatis.model.Car;
import lt.mybatis.model.Course;
import lt.mybatis.model.Student;
import lt.mybatis.model.StudentCourse;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StudentsMyBatis {
    @Inject
    private StudentMapper studentMapper;

    @Inject
    private CarMapper carMapper;
    @Inject
    private CourseMapper courseMapper;
    @Inject
    private StudentCourseMapper studentCourseMapper;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @Getter @Setter
    private List<Student> allStudents;

    @Getter @Setter
    private List<Course> CoursesByStudents;

    @PostConstruct
    public void init(){
        loadStudents();
    }

    public void loadStudents(){
        this.allStudents = studentMapper.selectAll();
    }

    @Transactional
    public String createStudent(){
        this.studentMapper.insert(studentToCreate);
        return "/mybatis/index?faces-redirect=true";
    }

    @Transactional
    public String addCarToStudent(Integer carId, Integer studentId){
        Car car = this.carMapper.selectByPrimaryKey(carId);
        if(car == null) return "false";
        Student student = this.studentMapper.selectByPrimaryKey(studentId);
        if(student == null) return "false";
        car.setStudentId(studentId);
        carMapper.updateByPrimaryKey(car);
        return "/mybatis/cars?faces-redirect=true";
    }
    @Transactional
    public String addCourseToStudent(Integer courseId, Integer studentId){
        Course course = this.courseMapper.selectByPrimaryKey(courseId);
        if(course == null) return "false";
        Student student = this.studentMapper.selectByPrimaryKey(studentId);
        if(student == null) return "false";
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        studentCourseMapper.insert(studentCourse);
        return "/mybatis/index?faces-redirect=true";
    }

    @Transactional
    public String deleteStudent(Student studentToDelete){
        this.studentMapper.deleteByPrimaryKey(studentToDelete.getId());
        return "/mybatis/index?faces-redirect=true";
    }
}