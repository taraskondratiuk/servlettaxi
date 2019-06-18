package ua.gladiator.model.entity;

import ua.gladiator.model.entity.enums.CarType;

public class CarDetailsDTO {
    private Long id;

    private String carMake;

    private CarType carType;

    private Long numRides;

    private Long totalEarned;

    private Long totalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Long getNumRides() {
        return numRides;
    }

    public void setNumRides(Long numRides) {
        this.numRides = numRides;
    }

    public Long getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(Long totalEarned) {
        this.totalEarned = totalEarned;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "CarDetailsDTO{" +
                "id=" + id +
                ", carMake='" + carMake + '\'' +
                ", carType=" + carType +
                ", numRides=" + numRides +
                ", totalEarned=" + totalEarned +
                ", totalTime=" + totalTime +
                '}';
    }
}
