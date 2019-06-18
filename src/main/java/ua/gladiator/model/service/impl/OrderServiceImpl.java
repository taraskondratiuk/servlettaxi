package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.dao.OrderDao;
import ua.gladiator.model.entity.Order;
import ua.gladiator.model.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {



    @Override
    public void addOrder(Order order) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        OrderDao orderDao = daoFactory.createOrderDao();
        orderDao.create(order);
        orderDao.close();
    }

    @Override
    public List<Order> getRidesByClientId(Long id) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        OrderDao orderDao = daoFactory.createOrderDao();
        List<Order> orders = orderDao.findByClientId(id);
        orderDao.close();
        return orders;
    }

    @Override
    public Integer getNumRides(Long id) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        OrderDao orderDao = daoFactory.createOrderDao();
        Integer num = orderDao.countByClientId(id);
        orderDao.close();
        return num;
    }
}
