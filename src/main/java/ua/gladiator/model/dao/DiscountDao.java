package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.Discount;
import ua.gladiator.model.entity.enums.SocialStatus;

public interface DiscountDao extends GenericDao<Discount> {
    Integer getSpecial();
    Integer getPersonal(Client client);
    Integer getPersonal(Long totalSpentValue, SocialStatus socialStatus);
}
