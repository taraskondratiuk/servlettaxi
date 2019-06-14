package ua.gladiator.model.service;

import ua.gladiator.model.entity.Order;
import ua.gladiator.model.entity.OrderDetailsDTO;

import java.util.List;

public interface UtilityService {

    public Long countPrice(Integer discount, Long time);
    public List<OrderDetailsDTO> buildListDetails(List<Order> orders);


}
