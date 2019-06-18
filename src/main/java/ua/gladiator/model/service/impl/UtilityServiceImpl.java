package ua.gladiator.model.service.impl;

import ua.gladiator.model.dao.*;
import ua.gladiator.model.entity.CarDetailsDTO;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.ClientDetailsDTO;
import ua.gladiator.model.entity.OrderDetailsDTO;
import ua.gladiator.model.entity.builders.CarDetailsDTOBuilder;
import ua.gladiator.model.entity.builders.ClientDetailsDTOBuilder;
import ua.gladiator.model.entity.builders.OrderDetailsDtoBuilder;
import ua.gladiator.model.entity.enums.Role;
import ua.gladiator.model.service.UtilityService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UtilityServiceImpl implements UtilityService {



    @Override
    public Long countPrice(Integer discount, Long time) {
        return time * (100 - discount) / 40;
    }

    @Override
    public List<OrderDetailsDTO> buildListOrdersDetails(Client client, Integer pageNumber, Integer pageSize) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TimeDao timeDao = daoFactory.createTimeDao();
        CarDao carDao = daoFactory.createCarDao();
        OrderDao orderDao = daoFactory.createOrderDao();
        List <OrderDetailsDTO> list = new ArrayList<>();
        orderDao.findByClientId(client.getId()).forEach(v -> list.add(new OrderDetailsDtoBuilder()
                .buildPrice(v.getPrice())
                .buildCarMake(carDao.findById(v.getCar_id()).getMake())
                .buildCarType(carDao.findById(v.getCar_id()).getType())
                .buildDestPlace(timeDao.findById(v.getTime_id()).getDestinationPlace())
                .buildInitPlace(timeDao.findById(v.getTime_id()).getInitialPlace())
                .buildTime(timeDao.findById(v.getTime_id()).getTime())
                .build()));
        orderDao.close();
        timeDao.close();
        carDao.close();


        return buildSubList(list, pageNumber, pageSize);
    }

    @Override
    public List<CarDetailsDTO> buildListCars(Integer pageNumber, Integer pageSize) {
        final List <CarDetailsDTO> list = new ArrayList<>();
        DaoFactory daoFactory = DaoFactory.getInstance();
        OrderDao orderDao = daoFactory.createOrderDao();
        CarDao carDao = daoFactory.createCarDao();
        carDao.findAll().forEach(v -> list.add(new CarDetailsDTOBuilder()
                .buildCarMake(v.getMake())
                .buildCarType(v.getType())
                .buildId(v.getIdcars())
                .buildNumRides(orderDao.countByCarId(v.getIdcars()))
                .buildTotalEarned(orderDao.countProfitByCarId(v.getIdcars()))
                .buildTotalTime(orderDao.countTimeByCarId(v.getIdcars()))
                .build()));

        orderDao.close();
        carDao.close();

        return buildSubList(list, pageNumber, pageSize);

    }


    @Override
    public List<ClientDetailsDTO> buildListClients(Integer pageNumber, Integer pageSize) {
        final List<ClientDetailsDTO> list = new ArrayList<>();
        DaoFactory daoFactory = DaoFactory.getInstance();
        OrderDao orderDao = daoFactory.createOrderDao();
        ClientDao clientDao = daoFactory.createClientDao();
        clientDao.findAll().forEach(v ->
                list.add(new ClientDetailsDTOBuilder()
                        .buildLogin(v.getLogin())
                        .buildMostCommonCarType(orderDao.getMostCommonCarType(v.getId()))
                        .buildNumRides((long)orderDao.countByClientId(v.getId()))
                        .buildSocialStatus(v.getSocialStatus())
                        .buildTotalSpentValue(v.getTotalSpentValue())
                        .buildTotalTime(orderDao.countTimeByClientId(v.getId()))
                        .build()));

        orderDao.close();
        clientDao.close();
        return buildSubList(list, pageNumber, pageSize);

    }

    private List buildSubList(List list, Integer pageNumber, Integer pageSize) {
        int start = pageNumber * pageSize;
        if(start >= list.size()) {
            return Collections.EMPTY_LIST;
        }
        int end = Math.min(pageNumber * pageSize + pageSize, list.size());
        return  list.subList(start, end);
    }
}
