package org.anyonetoo.anyonetoo.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.anyonetoo.anyonetoo.domain.Category;
import org.anyonetoo.anyonetoo.domain.Consumer;
import org.anyonetoo.anyonetoo.domain.Seller;
import org.anyonetoo.anyonetoo.domain.common.BaseEntity;
@Getter
@Entity
@Builder
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ConsumerPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prefer_id")
    private Long prefer_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

}
