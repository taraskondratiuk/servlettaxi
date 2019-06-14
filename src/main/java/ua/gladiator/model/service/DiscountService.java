package ua.gladiator.model.service;

import ua.gladiator.model.entity.Client;

public interface DiscountService {
    Integer getClientDiscount(Client client);

    Integer getSpecialDiscount();
}
