package org.anyonetoo.anyonetoo.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Seller")
public class Seller extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "seller")
    private List<SellerPrefer> sellerPrefers = new ArrayList<>();
}
