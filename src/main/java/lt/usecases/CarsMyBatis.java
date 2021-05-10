package lt.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.mybatis.model.Car;
import lt.mybatis.dao.CarMapper;
import lt.mybatis.dao.StudentMapper;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
@Model
public class CarsMyBatis {
    @Inject
    private StudentMapper studentMapper;
    @Inject
    private CarMapper carMapper;
    @Getter @Setter
    private List<Car> allCars;
    @Getter @Setter
    private Car carToCreate = new Car();

    @PostConstruct
    public void init(){
        loadAllCars();
    }
    @Transactional
    public String createCar(){
        this.carMapper.insert(carToCreate);
        return "/mybatis/cars?faces-redirect=true";
    }


    @Transactional
    public String deleteCar(Car carToDelete){
        this.carMapper.deleteByPrimaryKey(carToDelete.getId());
        return "/mybatis/cars?faces-redirect=true";
    }
    private void loadAllCars(){
        this.allCars = carMapper.selectAll();
    }
}
