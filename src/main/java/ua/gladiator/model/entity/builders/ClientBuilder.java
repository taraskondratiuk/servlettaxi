package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.enums.Role;
import ua.gladiator.model.entity.enums.SocialStatus;

public class ClientBuilder {
    private Long id;

    private String login;

    private String password;

    private SocialStatus socialStatus;

    private Long totalSpentValue;

    private Role role;

    private Integer personalDiscount;


    public ClientBuilder buildId(Long id) {
        this.id = id;
        return this;
    }

    public ClientBuilder buildLogin(String login) {
        this.login = login;
        return this;
    }

    public ClientBuilder buildPassword(String password) {
        this.password = password;
        return this;
    }

    public ClientBuilder buildSocialStatus(String socialStatus) {
        this.socialStatus = SocialStatus.valueOf(socialStatus);
        return this;
    }

    public ClientBuilder buildTotalSpentValue(Long totalSpentValue) {
        this.totalSpentValue = totalSpentValue;
        return this;
    }

    public ClientBuilder buildRole(String role) {
        this.role = Role.valueOf(role);
        return this;
    }

    public ClientBuilder buildPersonalDiscount(Integer personalDiscount) {
        this.personalDiscount = personalDiscount;
        return this;
    }

    public Client build() {
        Client client = new Client();
        client.setId(this.id);
        client.setLogin(this.login);
        client.setPassword(this.password);
        client.setPersonalDiscount(this.personalDiscount);
        client.setRole(this.role);
        client.setSocialStatus(this.socialStatus);
        client.setTotalSpentValue(this.totalSpentValue);
        return client;
    }
}
