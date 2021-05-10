package lt.persistence;
import lt.entities.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
@ApplicationScoped
public class CoursesDAO {
    @Inject
    private EntityManager em;
    public List<Course> loadAll() {
        return em.createNamedQuery("Course.findAll", Course.class).getResultList();
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }
    public void persist(Course course){
        this.em.persist(course);
    }
    public void delete(Course course){ this.em.remove(course); }
    public void update(Course course){ this.em.merge(course); }
    public Course findOne(Integer id) { return em.find(Course.class, id); }
}