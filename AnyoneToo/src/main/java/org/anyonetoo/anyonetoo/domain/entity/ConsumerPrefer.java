package org.anyonetoo.anyonetoo.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Consumer_Prefer")
public class ConsumerPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preferId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
