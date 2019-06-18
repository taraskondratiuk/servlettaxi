package ua.gladiator.model.dao.impl;

import ua.gladiator.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public CarDao createCarDao() {
        return new JDBCCarDao(getConnection());
    }

    @Override
    public ClientDao createClientDao() {
        return new JDBCClientDao(getConnection());
    }

    @Override
    public DiscountDao createDiscountDao() {
        return new JDBCDiscountDao(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new JDBCOrderDao(getConnection());
    }

    @Override
    public TimeDao createTimeDao() {
        return new JDBCTimeDao(getConnection());
    }
    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
