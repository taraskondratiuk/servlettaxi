package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.ClientDao;
import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private ClientDao clientDao = daoFactory.createClientDao();

    @Override
    public List<Client> getAll() {
        return clientDao.findAll();
    }

    @Override
    public boolean isRegistered(String login) {
        return clientDao.numRegistered(login) > 0;
    }

    @Override
    public void registerClient(Client client) {
        clientDao.create(client);
    }

    @Override
    public void addToSpentValue(Long id, Long value) {
        clientDao.updateSpentVal(id, value);

    }

    @Override
    public Client getCurrentClient() {
        return null;
    }

    @Override
    public boolean isRegistered(Long id) {
        return false;
    }

    @Override
    public boolean isRegistered(Client client) {
        return clientDao.numRegistered(client.getLogin()) > 0;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword, String login) {
        clientDao.changepw(oldPassword, newPassword, login);
    }

    @Override
    public void refreshDiscount(Integer newDiscount, String login) {
        clientDao.updateDiscount(newDiscount, login);
    }
}
