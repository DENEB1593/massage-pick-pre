package org.demo.massage.domain;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "partners")
@SQLDelete(sql = "update partners set delete_yn = Y")
@Entity
public class Partner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partnerToken;
    private String email;
    private String password;
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner", cascade = CascadeType.PERSIST)
    private List<Shop> shops = Lists.newArrayList();

    @Builder
    public Partner(String email,
                   String password,
                   String phone) {

        if(Strings.isNullOrEmpty(email)) throw new IllegalArgumentException("no email");
        if(Strings.isNullOrEmpty(password)) throw new IllegalArgumentException("no password");
        if(Strings.isNullOrEmpty(phone)) throw new IllegalArgumentException("no phone");

        this.partnerToken = partnerToken;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
