package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CarServicelmp implements CarService {
    
    @Autowired
    private CarDao carDao;

    @Override
    public void addCar(Car car) {
        carDao.addCar(car);

    }

    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Override
    public User getCar(String model, int series) {
        return null;
    }

}
