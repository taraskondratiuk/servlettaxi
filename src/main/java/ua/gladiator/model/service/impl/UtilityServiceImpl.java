package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.CarDao;
import ua.gladiator.model.dao.DaoFactory;
import ua.gladiator.model.dao.TimeDao;
import ua.gladiator.model.entity.Order;
import ua.gladiator.model.entity.OrderDetailsDTO;
import ua.gladiator.model.entity.builders.OrderDetailsDtoBuilder;
import ua.gladiator.model.service.UtilityService;

import java.util.ArrayList;
import java.util.List;

public class UtilityServiceImpl implements UtilityService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private TimeDao timeDao = daoFactory.createTimeDao();
    private CarDao carDao = daoFactory.createCarDao();

    @Override
    public Long countPrice(Integer discount, Long time) {
        return time * (100 - discount) / 40;
    }

    @Override
    public List<OrderDetailsDTO> buildListDetails(List<Order> orders) {
        List <OrderDetailsDTO> list = new ArrayList<>();
        orders.forEach(v -> list.add(new OrderDetailsDtoBuilder()
                .buildPrice(v.getPrice())
                .buildCarMake(carDao.findById(v.getCar_id()).getMake())
                .buildCarType(carDao.findById(v.getCar_id()).getType())
                .buildDestPlace(timeDao.findById(v.getTime_id()).getDestinationPlace())
                .buildInitPlace(timeDao.findById(v.getTime_id()).getInitialPlace())
                .buildTime(timeDao.findById(v.getTime_id()).getTime())
                .build()));
        return list;
    }
}
