package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.ClientDao;
import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {


    @Override
    public List<Client> getAll() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        List<Client> clients = clientDao.findAll();
        clientDao.close();
        return clients;
    }

    @Override
    public boolean isRegistered(String login) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        Integer num = clientDao.numRegistered(login);
        clientDao.close();
        return num > 0;
    }

    @Override
    public boolean isRegistered(String login, String password) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        boolean x = clientDao.isRegistered(login, password);
        clientDao.close();
        return x;
    }

    @Override
    public void registerClient(Client client) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        clientDao.create(client);
        clientDao.close();
    }

    @Override
    public void addToSpentValue(Long id, Long value) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        clientDao.updateSpentVal(id, value);
        clientDao.close();

    }

    @Override
    public Client getClient(String login) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        Client client = clientDao.findByLogin(login);
        clientDao.close();
        return client;
    }

    @Override
    public boolean isRegistered(Long id) {
        return false;
    }

    @Override
    public boolean isRegistered(Client client) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        Integer num = clientDao.numRegistered(client.getLogin());
        clientDao.close();
        return num > 0;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword, String login) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        clientDao.changepw(oldPassword, newPassword, login);
        clientDao.close();
    }

    @Override
    public void refreshDiscount(Integer newDiscount, String login) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ClientDao clientDao = daoFactory.createClientDao();
        clientDao.updateDiscount(newDiscount, login);
        clientDao.close();
    }
}
