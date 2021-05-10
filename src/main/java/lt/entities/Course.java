package lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@NamedQueries({@NamedQuery(name = "Course.findAll", query = "select a from Course as a")
})
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name= "student_course",
            joinColumns = @JoinColumn(name = "COURSE_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", nullable = false))
    @Getter @Setter
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
}
