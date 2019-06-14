package ua.gladiator.model.dao.impl;

import ua.gladiator.model.dao.DiscountDao;
import ua.gladiator.model.dao.mapper.ClientMapper;
import ua.gladiator.model.dao.mapper.DiscountMapper;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.Discount;

import java.sql.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class JDBCDiscountDao implements DiscountDao {
    private Connection connection;
    private ResultSet resultSet;
    private DiscountMapper discountMapper;

    private static ResourceBundle rb = ResourceBundle.getBundle("properties.db", new Locale("en", "US"));
    @Override
    public Integer getSpecial() {
        Integer spec = 0;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(rb.getString("discount.getspecial"));

            while (resultSet.next()) {
                spec += resultSet.getInt("discount");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spec;
    }

    @Override
    public Integer getPersonal(Client client) {
        Integer pers = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("discount.getpersonal"))) {
            preparedStatement.setLong(1, client.getTotalSpentValue());
            preparedStatement.setString(2, client.getSocialStatus().toString());


            if (resultSet.next()) {
                pers += resultSet.getInt("personal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pers;
    }

    public JDBCDiscountDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Discount entity) {

    }

    @Override
    public Discount findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Discount> findAll() {
        return null;
    }

    @Override
    public void update(Discount entity) {

    }

    @Override
    public void close() {

    }
}
