package ua.gladiator.model.dao.impl;

import ua.gladiator.model.dao.OrderDao;
import ua.gladiator.model.dao.mapper.DiscountMapper;
import ua.gladiator.model.dao.mapper.OrderMapper;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;
    private ResultSet resultSet;
    private OrderMapper orderMapper;

    private static ResourceBundle rb = ResourceBundle.getBundle("properties.db", new Locale("en", "US"));

    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Order> findByClientId(Long id) {

        List<Order> orders = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("order.findbyclientid"))) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(orderMapper.extractFromResultSet(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Integer countByClientId(Long id) {
        Integer sum = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("order.countbyclientid"))) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sum += (resultSet.getInt("count"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public void create(Order entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("order.add"))) {
            preparedStatement.setLong(1, entity.getCar_id());
            preparedStatement.setLong(2, entity.getPrice());
            preparedStatement.setLong(3, entity.getTime_id());
            preparedStatement.setLong(4, entity.getClientId());
            preparedStatement.setLong(5, entity.getWaitTime());
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("order.delete"))) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        final String sql = rb.getString("order.findall");
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                orders.add(orderMapper.extractFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void close() {

    }
}
