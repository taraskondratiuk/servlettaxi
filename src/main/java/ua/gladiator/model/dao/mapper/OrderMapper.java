package ua.gladiator.model.dao.mapper;

import ua.gladiator.model.entity.Order;
import ua.gladiator.model.entity.builders.OrderBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements GenericMapper<Order> {

    @Override
    public Order extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new OrderBuilder()
                .buildCar_id(resultSet.getLong("car_id"))
                .buildClientId(resultSet.getLong("client_id"))
                .buildId(resultSet.getLong("id"))
                .buildPrice(resultSet.getLong("price"))
                .buildWaitTime(resultSet.getLong("wait_time"))
                .buildTime_id(resultSet.getLong("time_id"))
                .build();
    }
}