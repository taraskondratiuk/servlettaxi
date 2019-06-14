package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.entity.enums.Street;

public class CarBuilder {
    private Long idcars;

    private String make;

    private Street place;

    private Boolean is_aviliable;

    private CarType type;

    public CarBuilder buildIdcars(Long idcars) {
        this.idcars = idcars;
        return this;
    }

    public CarBuilder buildMake(String make) {
        this.make = make;
        return this;
    }

    public CarBuilder buildPlace(String place) {
        this.place = Street.valueOf(place);
        return this;
    }

    public CarBuilder buildIs_aviliable(Boolean is_aviliable) {
        this.is_aviliable = is_aviliable;
        return this;
    }

    public CarBuilder buildType(String type) {
        this.type = CarType.valueOf(type)   ;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setIdcars(this.idcars);
        car.setIs_aviliable(this.is_aviliable);
        car.setMake(this.make);
        car.setPlace(this.place);
        car.setType(this.type);
        return car;
    }
}
