package ua.gladiator.model.dao.impl;

import ua.gladiator.model.dao.ClientDao;
import ua.gladiator.model.dao.mapper.CarMapper;
import ua.gladiator.model.dao.mapper.ClientMapper;
import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class JDBCClientDao implements ClientDao {
    private Connection connection;
    private ResultSet resultSet;
    private ClientMapper clientMapper;

    private static ResourceBundle rb = ResourceBundle.getBundle("properties.db", new Locale("en", "US"));

    @Override
    public Client findByLogin(String login) {
        Client client = new Client();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("client.findlogin"))) {
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client = clientMapper.extractFromResultSet(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Integer numRegistered(String login) {
        Integer counter = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("client.numregistered"))) {
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;
    }

    @Override
    public void updateSpentVal(Long id, Long additionalValue) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("client.updatespentval"))) {
            preparedStatement.setLong(1, additionalValue);
            preparedStatement.setLong(2, id);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void changepw(String oldPassword, String newPassword, String login) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("client.changepw"))) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, oldPassword);
            preparedStatement.setString(3, login);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateDiscount(Integer discount, String login) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("client.updatediscount"))) {
            preparedStatement.setInt(1, discount);
            preparedStatement.setString(2, login);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JDBCClientDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Client entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("client.create"))) {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setInt(3, entity.getPersonalDiscount());
            preparedStatement.setString(4, entity.getRole().toString());
            preparedStatement.setString(5, entity.getSocialStatus().toString());
            preparedStatement.setLong(6, entity.getTotalSpentValue());

            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        final String sql = rb.getString("client.findall");


        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                clients.add(clientMapper.extractFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void update(Client entity) {

    }

    @Override
    public void close() {

    }
}
