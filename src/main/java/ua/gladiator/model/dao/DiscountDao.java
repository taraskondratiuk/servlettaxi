package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Discount;

public interface DiscountDao extends GenericDao<Discount> {
    Integer getSpecial();
    Integer getPersonal();
}
