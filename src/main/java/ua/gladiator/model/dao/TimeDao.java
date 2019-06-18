package ua.gladiator.model.dao;

import ua.gladiator.model.entity.Time;

public interface TimeDao extends GenericDao<Time>{
    Long findLongTimeByStreets(String initialPlace, String destinationPlace);
    Time findTimeByStreets(String initialPlace, String destinationPlace);
}
