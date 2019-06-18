package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.CarDetailsDTO;
import ua.gladiator.model.entity.enums.CarType;

public class CarDetailsDTOBuilder {
    private Long id;

    private String carMake;

    private CarType carType;

    private Long numRides;

    private Long totalEarned;

    private Long totalTime;

    public CarDetailsDTOBuilder buildId(Long id) {
        this.id = id;
        return this;
    }

    public CarDetailsDTOBuilder buildCarMake(String carMake) {
        this.carMake = carMake;
        return this;
    }

    public CarDetailsDTOBuilder buildCarType(CarType carType) {
        this.carType = carType;
        return this;
    }

    public CarDetailsDTOBuilder buildNumRides(Long numRides) {
        this.numRides = numRides;
        return this;
    }

    public CarDetailsDTOBuilder buildNumRides(Integer numRides) {
        this.numRides =(long) numRides;
        return this;
    }

    public CarDetailsDTOBuilder buildTotalEarned(Long totalEarned) {
        this.totalEarned = totalEarned;
        return this;
    }

    public CarDetailsDTOBuilder buildTotalTime(Long totalTime) {
        this.totalTime = totalTime;
        return this;
    }
    public CarDetailsDTO build() {
        CarDetailsDTO carDetailsDTO = new CarDetailsDTO();
        carDetailsDTO.setCarMake(this.carMake);
        carDetailsDTO.setCarType(this.carType);
        carDetailsDTO.setId(this.id);
        carDetailsDTO.setNumRides(this.numRides);
        carDetailsDTO.setTotalEarned(this.totalEarned);
        carDetailsDTO.setTotalTime(this.totalTime);
        return carDetailsDTO;
    }
}
