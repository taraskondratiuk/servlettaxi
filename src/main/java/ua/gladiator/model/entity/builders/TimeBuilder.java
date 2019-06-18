package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.Time;
import ua.gladiator.model.entity.enums.Street;

public class TimeBuilder {
    private Long id;

    private Street initialPlace;

    private Street destinationPlace;

    private Long price;

    private Long time;

    public TimeBuilder buildId(Long id) {
        this.id = id;
        return this;
    }

    public TimeBuilder buildInitialPlace(String initialPlace) {
        this.initialPlace = Street.valueOf(initialPlace);
        return this;
    }

    public TimeBuilder buildDestinationPlace(String destinationPlace) {
        this.destinationPlace = Street.valueOf(destinationPlace);
        return this;
    }

    public TimeBuilder buildPrice(Long price) {
        this.price = price;
        return this;
    }

    public TimeBuilder buildTime(Long time) {
        this.time = time;
        return this;
    }

    public Time build() {
        Time time = new Time();
        time.setDestinationPlace(this.destinationPlace);
        time.setId(this.id);
        time.setInitialPlace(this.initialPlace);
        time.setPrice(this.price);
        time.setTime(this.time);
        return time;
    }
}
