package ua.gladiator.model.entity;

import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.entity.enums.Street;

public class OrderDetailsDTO {
    private String carMake;

    private Long price;
    private Long time;

    private Street initPlace;
    private Street destPlace;
    private CarType carType;

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Street getInitPlace() {
        return initPlace;
    }

    public void setInitPlace(Street initPlace) {
        this.initPlace = initPlace;
    }

    public Street getDestPlace() {
        return destPlace;
    }

    public void setDestPlace(Street destPlace) {
        this.destPlace = destPlace;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
