package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.ClientDetailsDTO;
import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.entity.enums.SocialStatus;

public class ClientDetailsDTOBuilder {
    private String login;

    private SocialStatus socialStatus;

    private Long numRides;

    private Long totalSpentValue;

    private Long totalTime;

    private CarType mostCommonCarType;

    public ClientDetailsDTOBuilder buildLogin(String login) {
        this.login = login;
        return this;
    }

    public ClientDetailsDTOBuilder buildSocialStatus(SocialStatus socialStatus) {
        this.socialStatus = socialStatus;
        return this;
    }

    public ClientDetailsDTOBuilder buildNumRides(Long numRides) {
        this.numRides = numRides;
        return this;
    }

    public ClientDetailsDTOBuilder buildTotalSpentValue(Long totalSpentValue) {
        this.totalSpentValue = totalSpentValue;
        return this;
    }

    public ClientDetailsDTOBuilder buildTotalTime(Long totalTime) {
        this.totalTime = totalTime;
        return this;
    }

    public ClientDetailsDTOBuilder buildMostCommonCarType(CarType mostCommonCarType) {
        this.mostCommonCarType = mostCommonCarType;
        return this;
    }

    public ClientDetailsDTO build() {
        ClientDetailsDTO clientDetailsDTO = new ClientDetailsDTO();
        clientDetailsDTO.setLogin(this.login);
        clientDetailsDTO.setMostCommonCarType(this.mostCommonCarType);
        clientDetailsDTO.setNumRides(this.numRides);
        clientDetailsDTO.setSocialStatus(this.socialStatus);
        clientDetailsDTO.setTotalSpentValue(this.totalSpentValue);
        clientDetailsDTO.setTotalTime(this.totalTime);
        return clientDetailsDTO;
    }
}
