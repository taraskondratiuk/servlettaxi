package ua.gladiator.model.service;

import ua.gladiator.model.entity.Time;
import ua.gladiator.model.entity.enums.Street;

public interface TimeService {
    Long findLongTime(Street initialPlace, Street destinationPlace);

    Time findTime(Street initialPlace, Street destinationPlace);

    Time getTimeById(Long id);
}
