package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.dao.TimeDao;
import ua.gladiator.model.entity.Time;
import ua.gladiator.model.entity.enums.Street;
import ua.gladiator.model.service.TimeService;

public class TimeServiceImpl implements TimeService {


    @Override
    public Long findLongTime(Street initialPlace, Street destinationPlace) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TimeDao timeDao = daoFactory.createTimeDao();
        Long time = timeDao.findLongTimeByStreets(initialPlace.toString(), destinationPlace.toString());
        timeDao.close();
        return time;
    }

    @Override
    public Time findTime(Street initialPlace, Street destinationPlace) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TimeDao timeDao = daoFactory.createTimeDao();
        Time time = timeDao.findTimeByStreets(initialPlace.toString(), destinationPlace.toString());
        timeDao.close();
        return time;
    }

    @Override
    public Time getTimeById(Long id) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TimeDao timeDao = daoFactory.createTimeDao();
        Time time = timeDao.findById(id);
        timeDao.close();
        return time;
    }
}
