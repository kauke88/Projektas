package lt.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.entities.Car;
import lt.entities.Student;
import lt.persistence.CarsDAO;
import lt.persistence.StudentsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
@Model
public class Cars {
    @Inject
    private StudentsDAO studentsDAO;
    @Inject
    private CarsDAO carsDAO;
    @Getter
    @Setter
    private List<Car> allCars;
    @Getter @Setter
    private Car carToCreate = new Car();
    public void loadCars(){
        this.allCars = carsDAO.loadAll();
    }

    @PostConstruct
    public void init(){
        loadAllCars();
    }
    @Transactional
    public String createCar(){
        this.carsDAO.persist(carToCreate);
        return "/cars?faces-redirect=true";
    }


    @Transactional
    public String deleteCar(Car carToDelete){
        this.carsDAO.delete(carToDelete);
        return "/cars?faces-redirect=true";
    }
    private void loadAllCars(){
        this.allCars = carsDAO.loadAll();
    }
}
