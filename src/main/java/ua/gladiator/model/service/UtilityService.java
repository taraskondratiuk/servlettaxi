package ua.gladiator.model.service;

import ua.gladiator.model.entity.*;

import java.awt.print.Pageable;
import java.util.List;

public interface UtilityService {

    Long countPrice(Integer discount, Long time);


    List<OrderDetailsDTO> buildListOrdersDetails(Client client, Integer pageNumber, Integer pageSize);


    List<CarDetailsDTO> buildListCars(Integer pageNumber, Integer pageSize);

    List<ClientDetailsDTO> buildListClients(Integer pageNumber, Integer pageSize);
}
