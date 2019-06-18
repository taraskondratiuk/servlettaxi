package ua.gladiator.model.entity;

import ua.gladiator.model.entity.enums.Street;

public class Time {
    private Long id;

    private Street initialPlace;

    private Street destinationPlace;

    private Long price;

    private Long time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Street getInitialPlace() {
        return initialPlace;
    }

    public void setInitialPlace(Street initialPlace) {
        this.initialPlace = initialPlace;
    }

    public Street getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(Street destinationPlace) {
        this.destinationPlace = destinationPlace;
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
}
