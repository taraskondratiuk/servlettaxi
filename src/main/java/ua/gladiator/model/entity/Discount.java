package ua.gladiator.model.entity;

import ua.gladiator.model.entity.enums.SocialStatus;

public class Discount {
    private Long iddiscounts;

    private Integer discount;

    private Long minSpentValue;

    private SocialStatus socialStatus;

    private Boolean specialDiscount;

    public Long getIddiscounts() {
        return iddiscounts;
    }

    public void setIddiscounts(Long iddiscounts) {
        this.iddiscounts = iddiscounts;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Long getMinSpentValue() {
        return minSpentValue;
    }

    public void setMinSpentValue(Long minSpentValue) {
        this.minSpentValue = minSpentValue;
    }

    public SocialStatus getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(SocialStatus socialStatus) {
        this.socialStatus = socialStatus;
    }

    public Boolean getSpecialDiscount() {
        return specialDiscount;
    }

    public void setSpecialDiscount(Boolean specialDiscount) {
        this.specialDiscount = specialDiscount;
    }
}
