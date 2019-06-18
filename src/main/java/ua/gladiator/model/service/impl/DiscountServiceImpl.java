package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.dao.DiscountDao;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.enums.SocialStatus;
import ua.gladiator.model.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {


    @Override
    public Integer getClientDiscount(Client client) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DiscountDao discountDao = daoFactory.createDiscountDao();
        Integer discount = discountDao.getPersonal(client);
        discountDao.close();
        return discount;
    }

    @Override
    public Integer getClientDiscount(Long totalSpentValue, SocialStatus socialStatus) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        DiscountDao discountDao = daoFactory.createDiscountDao();
        Integer discount = discountDao.getPersonal(totalSpentValue, socialStatus);
        discountDao.close();
        return discount;
    }

    @Override
    public Integer getSpecialDiscount() {

        DaoFactory daoFactory = DaoFactory.getInstance();

        DiscountDao discountDao = daoFactory.createDiscountDao();

        Integer discount = discountDao.getSpecial();

        return discount;
    }
}
