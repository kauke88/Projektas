package lt.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.entities.Car;
import lt.entities.Course;
import lt.entities.Student;
import lt.persistence.CarsDAO;
import lt.persistence.CoursesDAO;
import lt.persistence.StudentsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Students {
    @Inject
    private StudentsDAO studentsDAO;

    @Inject
    private CarsDAO carsDAO;
    @Inject
    private CoursesDAO coursesDAO;

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
        this.allStudents = studentsDAO.loadAll();
    }

    @Transactional
    public String createStudent(){
        this.studentsDAO.persist(studentToCreate);
        return "/index?faces-redirect=true";
    }

    @Transactional
    public String addCarToStudent(Integer carId, Integer studentId){
        Car car = this.carsDAO.findOne(carId);
        if(car == null) return "false";
        Student student = this.studentsDAO.findOne(studentId);
        if(student == null) return "false";
        car.setStudent(student);
        carsDAO.persist(car);
        return "/cars?faces-redirect=true";
    }
    @Transactional
    public String addCourseToStudent(Integer courseId, Integer studentId){
        Course course = this.coursesDAO.findOne(courseId);
        if(course == null) return "false";
        Student student = this.studentsDAO.findOne(studentId);
        if(student == null) return "false";
        course.addStudent(student);
        coursesDAO.persist(course);
        return "/index?faces-redirect=true";
    }

    @Transactional
    public String deleteStudent(Student studentToDelete){
        this.studentsDAO.delete(studentToDelete);
        return "/index?faces-redirect=true";
    }
}