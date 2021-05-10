package lt.persistence;
import lt.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
@ApplicationScoped
public class CarsDAO {
    @Inject
    private EntityManager em;
    public List<Car> loadAll() {
        return em.createNamedQuery("Car.findAll", Car.class).getResultList();
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }
    public void persist(Car car){
        this.em.persist(car);
    }
    public void delete(Car car){ this.em.remove(car); }
    public void update(Car car){ this.em.merge(car); }
    public Car findOne(Integer id) { return em.find(Car.class, id); }
}