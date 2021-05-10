package lt.persistence;
import lt.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
@ApplicationScoped
public class StudentsDAO {
    @Inject
    private EntityManager em;
    public List<Student> loadAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }
    public void persist(Student student){
        this.em.persist(student);
    }
    public void delete(Student student){ this.em.remove(student); }
    public void update(Student student){ this.em.merge(student); }
    public Student findOne(Integer id) { return em.find(Student.class, id); }
}