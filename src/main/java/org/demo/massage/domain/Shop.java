package org.demo.massage.domain;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Table(name = "shops")
@SQLDelete(sql = "update shops set delete_yn = Y")
@Entity
public class Shop extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ShopFragment shopFragment;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop", cascade = CascadeType.PERSIST)
    private List<Program> programs = Lists.newArrayList();

    @Builder
    public Shop(ShopFragment shopFragment) {
        Objects.requireNonNull(shopFragment);

        this.shopFragment = shopFragment;
    }
}
