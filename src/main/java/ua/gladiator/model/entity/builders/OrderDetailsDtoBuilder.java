package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.OrderDetailsDTO;
import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.entity.enums.Street;

public class OrderDetailsDtoBuilder {
    private String carMake;

    private Long price;
    private Long time;

    private Street initPlace;
    private Street destPlace;
    private CarType carType;

    public OrderDetailsDtoBuilder buildCarMake(String carMake) {
        this.carMake = carMake;
        return this;
    }

    public OrderDetailsDtoBuilder buildPrice(Long price) {
        this.price = price;
        return this;
    }

    public OrderDetailsDtoBuilder buildTime(Long time) {
        this.time = time;
        return this;
    }

    public OrderDetailsDtoBuilder buildInitPlace(Street initPlace) {
        this.initPlace = initPlace;
        return this;
    }

    public OrderDetailsDtoBuilder buildDestPlace(Street destPlace) {
        this.destPlace = destPlace;
        return this;
    }

    public OrderDetailsDtoBuilder buildCarType(CarType carType) {
        this.carType = carType;
        return this;
    }

    public OrderDetailsDTO build() {
        OrderDetailsDTO dto = new OrderDetailsDTO();
        dto.setPrice(this.price);
        dto.setTime(this.time);
        dto.setCarMake(this.carMake);
        dto.setCarType(this.carType);
        dto.setDestPlace(this.destPlace);
        dto.setInitPlace(this.initPlace);
        return dto;
    }
}
