package org.demo.massage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Embeddable
@NoArgsConstructor
public class ShopFragment {
    private String openAt;
    private String closeAt;
    private String comeTo;
    private String address; // 카카오 지도 API값
    private String shopInfo;
    private String introduce;
    private String notice;
    private String keyword;
    private String contact;
    private String manager;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Builder
    public ShopFragment(String openAt,
                        String closeAt,
                        String comeTo,
                        String address,
                        String shopInfo,
                        String introduce,
                        String notice,
                        String keyword,
                        String contact,
                        String manager,
                        ServiceType serviceType) {
        this.openAt = openAt;
        this.closeAt = closeAt;
        this.comeTo = comeTo;
        this.address = address;
        this.shopInfo = shopInfo;
        this.introduce = introduce;
        this.notice = notice;
        this.keyword = keyword;
        this.contact = contact;
        this.manager = manager;
        this.serviceType = serviceType;
    }

    @Getter
    @AllArgsConstructor
    public enum ServiceType {
        SWEDISH("스웨디시"),
        THAI("타이"),
        CHINESE("중국식"),
        AROMA("아로마");

        private final String description;
    }
}
