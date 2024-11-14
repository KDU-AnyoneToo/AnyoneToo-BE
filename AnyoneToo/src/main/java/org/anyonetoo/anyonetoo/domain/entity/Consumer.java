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
@Table(name = "Consumer")
public class Consumer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumerId;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "consumer")
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "consumer")
    private List<ConsumerPrefer> consumerPrefers = new ArrayList<>();
}
