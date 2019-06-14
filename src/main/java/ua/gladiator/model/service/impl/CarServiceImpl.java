package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.CarDao;
import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private CarDao carDao = daoFactory.createCarDao();

    @Override
    public Car getCarById(Long carId) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return carDao.findAll();
    }

    @Override
    public List<Car> getAvailable() {
        return carDao.findAvailable();
    }

    @Override
    public List<Car> getAvailableType(CarType type) {
        return carDao.findAvailableByType(String.valueOf(type));
    }
}
