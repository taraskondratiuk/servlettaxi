package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.enums.CarType;

import java.util.List;

public interface CarDao extends GenericDao<Car> {
    List<Car> findAvailable();
    List<Car> findAvailableByType(String type);

}
