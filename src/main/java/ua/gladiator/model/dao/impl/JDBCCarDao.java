package ua.gladiator.model.dao.impl;

import ua.gladiator.model.dao.CarDao;
import ua.gladiator.model.dao.mapper.CarMapper;
import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.enums.CarType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class JDBCCarDao implements CarDao {
    private Connection connection;
    private ResultSet resultSet;
    private CarMapper carMapper;

    private static ResourceBundle rb = ResourceBundle.getBundle("properties.db", new Locale("en", "US"));

    public JDBCCarDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Car> findAvailable() {
        List<Car> cars = new ArrayList<>();
        final String sql = rb.getString("car.findavail");

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            CarMapper carMapper = new CarMapper();

            while (resultSet.next()) {
                cars.add(carMapper.extractFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public List<Car> findAvailableByType(String type) {
        List<Car> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("car.findavailtype"))) {
            preparedStatement.setString(1, type);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(carMapper.extractFromResultSet(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    @Override
    public void create(Car entity) {

    }


    @Override
    public Car findById(Long id) {
        Car car = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("car.findid"))) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car =  carMapper.extractFromResultSet(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("car.delete"))) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        final String sql = rb.getString("car.findall");


        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            CarMapper carMapper = new CarMapper();

            while (resultSet.next()) {
                cars.add(carMapper.extractFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void update(Car entity) {

    }

    @Override
    public void close() {

    }
}
