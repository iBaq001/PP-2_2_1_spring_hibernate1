package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class CarServicelmp implements CarService {

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public List<Car> listAllCars() {
        return carDao.listAllCars();
    }
}