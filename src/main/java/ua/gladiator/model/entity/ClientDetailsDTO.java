package ua.gladiator.model.entity;

import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.entity.enums.SocialStatus;

public class ClientDetailsDTO {

    private String login;

    private SocialStatus socialStatus;

    private Long numRides;

    private Long totalSpentValue;

    private Long totalTime;

    private CarType mostCommonCarType;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public SocialStatus getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(SocialStatus socialStatus) {
        this.socialStatus = socialStatus;
    }

    public Long getNumRides() {
        return numRides;
    }

    public void setNumRides(Long numRides) {
        this.numRides = numRides;
    }

    public Long getTotalSpentValue() {
        return totalSpentValue;
    }

    public void setTotalSpentValue(Long totalSpentValue) {
        this.totalSpentValue = totalSpentValue;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public CarType getMostCommonCarType() {
        return mostCommonCarType;
    }

    public void setMostCommonCarType(CarType mostCommonCarType) {
        this.mostCommonCarType = mostCommonCarType;
    }
}
