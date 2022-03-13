package org.demo.massage.domain;

import org.demo.massage.domain.partner.Partner;
import org.demo.massage.domain.partner.PartnerRepository;
import org.demo.massage.infra.JpaConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(
        includeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = JpaConfig.class))
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PartnerTest {

    private final PartnerRepository partnerRepository;

    @Autowired
    PartnerTest(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @DisplayName("파트너_추가")
    @Test
    void addPartnerTest() {
        Partner partner = Partner.builder()
                .email("lee@naver.com")
                .password("1234")
                .phone("01012341234")
                .build();

        partnerRepository.save(partner);
        List<Partner> partners = partnerRepository.findAll();

        assertEquals(1, partnerRepository.findAll().size());
    }

}