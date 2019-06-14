package ua.gladiator.model.service;

import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.enums.CarType;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    List<Car> getAvailable();

    List<Car> getAvailableType(CarType type);

    Car getCarById(Long carId);
}
