package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.dao.DiscountDao;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private DiscountDao discountDao = daoFactory.createDiscountDao();

    @Override
    public Integer getClientDiscount(Client client) {
        return discountDao.getPersonal(client);
    }

    @Override
    public Integer getSpecialDiscount() {
        return discountDao.getSpecial();
    }
}
