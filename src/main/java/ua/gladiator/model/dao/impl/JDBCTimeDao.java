package ua.gladiator.model.dao.impl;

import ua.gladiator.model.dao.TimeDao;
import ua.gladiator.model.dao.mapper.TimeMapper;
import ua.gladiator.model.entity.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class JDBCTimeDao implements TimeDao {
    private Connection connection;
    private ResultSet resultSet;
    private TimeMapper timeMapper;

    private static ResourceBundle rb = ResourceBundle.getBundle("properties.db", new Locale("en", "US"));

    public JDBCTimeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long findLongTimeByStreets(String initialPlace, String destinationPlace) {
        Long time = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("time.findlongtimebystreets"))) {
            preparedStatement.setString(1, initialPlace);
            preparedStatement.setString(2, destinationPlace);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                time = resultSet.getLong("time");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public Time findTimeByStreets(String initialPlace, String destinationPlace) {
        Time time = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("time.findtmiebystreets"))) {
            preparedStatement.setString(1, initialPlace);
            preparedStatement.setString(2, destinationPlace);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                time = timeMapper.extractFromResultSet(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public void create(Time entity) {

    }

    @Override
    public Time findById(Long id) {
        Time time = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                rb.getString("time.findtimebyid"))) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                time =  timeMapper.extractFromResultSet(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Time> findAll() {
        return null;
    }

    @Override
    public void update(Time entity) {

    }

    @Override
    public void close() {

    }
}
