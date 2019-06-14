package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Client;

public interface ClientDao extends GenericDao<Client> {
    Client findByLogin(String login);
    Integer numRegistered(String login);
    void updateSpentVal(Long id, Long additionalValue);
    void changepw(String password, String login);
    void updateDiscount(Integer discount, Long id);

}
