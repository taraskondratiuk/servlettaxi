package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.CarDao;
import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    @Override
    public Car getCarById(Long carId) {

        CarDao carDao = daoFactory.createCarDao();
        Car car = carDao.findById(carId);
        carDao.close();
        return car;
    }

    @Override
    public List<Car> getAll() {

        CarDao carDao = daoFactory.createCarDao();
        List<Car> cars = carDao.findAll();
        carDao.close();
        return cars;
    }

    @Override
    public List<Car> getAvailable() {

        CarDao carDao = daoFactory.createCarDao();
        List<Car> cars = carDao.findAvailable();
        carDao.close();
        return cars;
    }

    @Override
    public List<Car> getAvailableType(CarType type) {

        CarDao carDao = daoFactory.createCarDao();
        List<Car> cars = carDao.findAvailableByType(String.valueOf(type));
        carDao.close();
        return cars;
    }
}
