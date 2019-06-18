package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Order;
import ua.gladiator.model.entity.enums.CarType;

import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> findByClientId(Long id);
    Integer countByClientId(Long id);

    Integer countByCarId(Long id);

    Long countProfitByCarId(Long idcars);


    Long countTimeByCarId(Long idcars);

    CarType getMostCommonCarType(Long id);

    Long countTimeByClientId(Long id);
}
