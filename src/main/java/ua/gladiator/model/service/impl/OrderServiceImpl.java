package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.dao.OrderDao;
import ua.gladiator.model.entity.Order;
import ua.gladiator.model.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private OrderDao orderDao = daoFactory.createOrderDao();

    @Override
    public void addOrder(Order order) {
        orderDao.create(order);
    }

    @Override
    public List<Order> getRidesByClientId(Long id) {
        return orderDao.findByClientId(id);
    }

    @Override
    public Integer getNumRides(Long id) {
        return orderDao.countByClientId(id);
    }
}
