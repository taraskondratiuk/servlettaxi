package ua.gladiator.model.dao.mapper;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.builders.ClientBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements GenericMapper<Client> {
    @Override
    public Client extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new ClientBuilder()
                .buildId(resultSet.getLong("id"))
                .buildLogin(resultSet.getString("login"))
                .buildPassword(resultSet.getString("password"))
                .buildPersonalDiscount(resultSet.getInt("personal_discount"))
                .buildTotalSpentValue(resultSet.getLong("total_spent_value"))
                .buildRole(resultSet.getString("role"))
                .buildSocialStatus(resultSet.getString("social_status"))
                .build();
    }
}
