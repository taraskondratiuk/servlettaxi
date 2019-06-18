package ua.gladiator.model.service;

import ua.gladiator.model.entity.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    List<Order> getRidesByClientId(Long id);
    Integer getNumRides (Long id);
}
