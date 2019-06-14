package ua.gladiator.model.dao.mapper;

import ua.gladiator.model.entity.Time;
import ua.gladiator.model.entity.builders.TimeBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeMapper implements GenericMapper<Time> {
    @Override
    public Time extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new TimeBuilder()
                .buildDestinationPlace(resultSet.getString("destination_place"))
                .buildInitialPlace(resultSet.getString("initial_place"))
                .buildTime(resultSet.getLong("time"))
                .buildId(resultSet.getLong("id"))
                .build();
    }
}