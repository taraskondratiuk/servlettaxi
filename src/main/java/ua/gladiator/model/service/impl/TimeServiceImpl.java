package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.dao.TimeDao;
import ua.gladiator.model.entity.Time;
import ua.gladiator.model.entity.enums.Street;
import ua.gladiator.model.service.TimeService;

public class TimeServiceImpl implements TimeService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private TimeDao timeDao = daoFactory.createTimeDao();

    @Override
    public Long findLongTime(Street initialPlace, Street destinationPlace) {
        return timeDao.findLongTimeByStreets(initialPlace.toString(), destinationPlace.toString());
    }

    @Override
    public Time findTime(Street initialPlace, Street destinationPlace) {
        return timeDao.findTimeByStreets(initialPlace.toString(), destinationPlace.toString());
    }

    @Override
    public Time getTimeById(Long id) {
        return timeDao.findById(id);
    }
}
