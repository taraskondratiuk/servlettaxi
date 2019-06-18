package ua.gladiator.model.entity;

import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.entity.enums.Street;

public class Car {

    private Long idcars;

    private String make;

    private Street place;

    private Boolean is_aviliable;

    private CarType type;

    public Long getIdcars() {
        return idcars;
    }

    public void setIdcars(Long idcars) {
        this.idcars = idcars;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Street getPlace() {
        return place;
    }

    public void setPlace(Street place) {
        this.place = place;
    }

    public Boolean getIs_aviliable() {
        return is_aviliable;
    }

    public void setIs_aviliable(Boolean is_aviliable) {
        this.is_aviliable = is_aviliable;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idcars=" + idcars +
                ", make='" + make + '\'' +
                ", place=" + place +
                ", is_aviliable=" + is_aviliable +
                ", type=" + type +
                '}';
    }
}
