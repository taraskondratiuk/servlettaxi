package ua.gladiator.model.service;

import ua.gladiator.model.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();

    /*@Override
    UserDetails loadUserByUsername(String s);*/

    boolean isRegistered(String login);
    void registerClient(Client client);

    void addToSpentValue(Long id, Long value);
    Client getClient(String login);
    boolean isRegistered(Long id);
    boolean isRegistered(Client client);
    boolean isRegistered(String login, String password);

    void changePassword(String oldPassword, String newPassword, String login);


    void refreshDiscount(Integer newDiscount, String login);
}
