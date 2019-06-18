package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Client;

public interface ClientDao extends GenericDao<Client> {
    Client findByLogin(String login);
    Integer numRegistered(String login);
    void updateSpentVal(Long id, Long additionalValue);
    void changepw(String oldPassword, String newPassword, String login);
    void updateDiscount(Integer discount, String login);
    Boolean isRegistered(String login, String password);

}
