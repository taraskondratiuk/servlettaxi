package ua.gladiator.model.entity.builders;

import ua.gladiator.model.entity.Discount;
import ua.gladiator.model.entity.enums.SocialStatus;

public class DiscountBuilder {
    private Long iddiscounts;

    private Integer discount;

    private Long minSpentValue;

    private SocialStatus socialStatus;

    private Boolean specialDiscount;

    public DiscountBuilder buildIddiscounts(Long iddiscounts) {
        this.iddiscounts = iddiscounts;
        return this;
    }

    public DiscountBuilder buildDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public DiscountBuilder buildMinSpentValue(Long minSpentValue) {
        this.minSpentValue = minSpentValue;
        return this;
    }

    public DiscountBuilder buildSocialStatus(String socialStatus) {
        this.socialStatus = SocialStatus.valueOf(socialStatus);
        return this;
    }

    public DiscountBuilder buildSpecialDiscount(Boolean specialDiscount) {
        this.specialDiscount = specialDiscount;
        return this;
    }

    public Discount build() {
        Discount discount = new Discount();
        discount.setDiscount(this.discount);
        discount.setIddiscounts(this.iddiscounts);
        discount.setMinSpentValue(this.minSpentValue);
        discount.setSocialStatus(this.socialStatus);
        discount.setSpecialDiscount(this.specialDiscount);
        return discount;
    }
}

