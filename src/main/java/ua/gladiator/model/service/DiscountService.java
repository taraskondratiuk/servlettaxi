package ua.gladiator.model.service;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.enums.SocialStatus;

public interface DiscountService {
    Integer getClientDiscount(Client client);

    Integer getClientDiscount(Long totalSpentValue, SocialStatus socialStatus);

    Integer getSpecialDiscount();
}
