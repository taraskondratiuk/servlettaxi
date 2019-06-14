package ua.gladiator.model.entity;

import ua.gladiator.model.entity.enums.Role;
import ua.gladiator.model.entity.enums.SocialStatus;

public class Client {
    private Long id;

    private String login;

    private String password;

    private SocialStatus socialStatus;

    private Long totalSpentValue;

    private Role role;

    private Integer personalDiscount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SocialStatus getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(SocialStatus socialStatus) {
        this.socialStatus = socialStatus;
    }

    public Long getTotalSpentValue() {
        return totalSpentValue;
    }

    public void setTotalSpentValue(Long totalSpentValue) {
        this.totalSpentValue = totalSpentValue;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(Integer personalDiscount) {
        this.personalDiscount = personalDiscount;
    }
}
