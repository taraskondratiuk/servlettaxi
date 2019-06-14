package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Order;
import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> findByClientId(Long id);
    Integer countByClientId(Long id);
}
