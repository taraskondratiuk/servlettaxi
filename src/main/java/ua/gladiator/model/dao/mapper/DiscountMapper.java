package ua.gladiator.model.dao.mapper;

import ua.gladiator.model.entity.Discount;
import ua.gladiator.model.entity.builders.DiscountBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountMapper implements GenericMapper<Discount> {
    @Override
    public Discount extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new DiscountBuilder()
                .buildDiscount(resultSet.getInt("discount"))
                .buildIddiscounts(resultSet.getLong("iddiscounts"))
                .buildMinSpentValue(resultSet.getLong("min_spent_value"))
                .buildSocialStatus(resultSet.getString("social_status"))
                .buildSpecialDiscount(resultSet.getBoolean("special_discount"))
                .build();
    }
}