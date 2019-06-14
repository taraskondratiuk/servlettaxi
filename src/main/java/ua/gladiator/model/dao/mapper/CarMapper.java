package ua.gladiator.model.dao.mapper;

import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.builders.CarBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements GenericMapper<Car> {
    @Override
    public Car extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new CarBuilder()
                .buildIdcars(resultSet.getLong("idcars"))
                .buildIs_aviliable(resultSet.getBoolean("is_aviliable"))
                .buildMake(resultSet.getString("make"))
                .buildPlace(resultSet.getString("place"))
                .buildType(resultSet.getString("type"))
                .build();
    }
}
