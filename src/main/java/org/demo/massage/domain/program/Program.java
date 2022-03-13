package org.demo.massage.domain.program;

import com.google.common.base.Strings;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.demo.massage.domain.shop.Shop;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table(name = "programs")
@SQLDelete(sql = "update programs set delete_yn = Y")
@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    private String title;
    private String description;
    private int price;
    private int discountPrice;

    @Builder
    public Program(String title,
                   String description,
                   int price,
                   int discountPrice) {

        if (Strings.isNullOrEmpty(title)) throw new IllegalArgumentException("no title");
        if (Strings.isNullOrEmpty(description)) throw new IllegalArgumentException("description");
        if (price < 0) throw new IllegalArgumentException("price is lower than 0");
        if (discountPrice < 0) throw new IllegalArgumentException("discountPrice is lower than 0");

        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
    }
}
