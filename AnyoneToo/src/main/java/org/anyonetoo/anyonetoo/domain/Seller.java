package org.anyonetoo.anyonetoo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.anyonetoo.anyonetoo.domain.common.BaseEntity;
import org.anyonetoo.anyonetoo.domain.mapping.ConsumerPrefer;
import org.anyonetoo.anyonetoo.domain.mapping.SellerPrefer;

import java.util.List;

//@Getter
//@Entity
//@Builder
//@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
//public class Seller extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "seller_id")
//    private Long seller_id;
//
//    private String id;
//    private String password;
//    private String name;
//    private Long age;
//
//    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Product> products;
//
//    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<SellerPrefer> sellerPrefers;
//
//}

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;
    private Long age;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SellerPrefer> sellerPrefers;

}
