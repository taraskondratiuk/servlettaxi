package ua.gladiator.model.dao.impl;

import ua.gladiator.model.dao.DiscountDao;
import ua.gladiator.model.dao.mapper.ClientMapper;
import ua.gladiator.model.dao.mapper.DiscountMapper;
import ua.gladiator.model.entity.Discount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public Integer getPersonal() {
        Integer pers = 0;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(rb.getString("discount.getpersonal"));

            if (resultSet.next()) {
                pers += resultSet.getInt("personal");
            }

        } catch (SQLException e) {
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
