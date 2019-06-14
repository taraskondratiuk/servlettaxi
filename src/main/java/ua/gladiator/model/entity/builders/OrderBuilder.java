package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.Order;

public class OrderBuilder {
    private Long id;

    private Long car_id;

    private Long clientId;

    private Long time_id;

    private Long price;

    private Long waitTime;

    public OrderBuilder buildId(Long id) {
        this.id = id;
        return this;
    }

    public OrderBuilder buildCar_id(Long car_id) {
        this.car_id = car_id;
        return this;
    }

    public OrderBuilder buildClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public OrderBuilder buildTime_id(Long time_id) {
        this.time_id = time_id;
        return this;
    }

    public OrderBuilder buildPrice(Long price) {
        this.price = price;
        return this;
    }

    public OrderBuilder buildWaitTime(Long waitTime) {
        this.waitTime = waitTime;
        return this;
    }

    public Order build() {
        Order order = new Order();
        order.setCar_id(this.car_id);
        order.setClientId(this.clientId);
        order.setId(this.id);
        order.setPrice(this.price);
        order.setWaitTime(this.waitTime);
        order.setTime_id(this.time_id);
        return order;
    }
}
