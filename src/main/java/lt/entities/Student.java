package lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@NamedQueries({@NamedQuery(name = "Student.findAll", query = "select a from Student as a")
})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

    @ManyToMany(mappedBy="students")
    @Getter @Setter
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course)
    {
        courses.add(course);
    }
    public void deleteStudent()
    {

    }
    public void addCar(Car car) {
        cars.add(car);
    }
}
