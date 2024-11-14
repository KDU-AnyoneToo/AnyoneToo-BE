package org.anyonetoo.anyonetoo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.anyonetoo.anyonetoo.domain.common.BaseEntity;
import org.anyonetoo.anyonetoo.domain.mapping.ConsumerPrefer;
import org.anyonetoo.anyonetoo.domain.mapping.SellerPrefer;

import java.util.List;

@Getter
@Entity
@Builder
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long category_id;

    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConsumerPrefer> consumerPrefers;


    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SellerPrefer> sellerPrefers;


}
