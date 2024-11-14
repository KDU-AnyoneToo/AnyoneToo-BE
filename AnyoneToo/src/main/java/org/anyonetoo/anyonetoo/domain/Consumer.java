package org.anyonetoo.anyonetoo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.anyonetoo.anyonetoo.domain.common.BaseEntity;
import org.anyonetoo.anyonetoo.domain.mapping.ConsumerPrefer;

import java.util.List;

@Getter
@Entity
@Builder
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Consumer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumer_id")
    private Long consumer_id;

    private String id;
    private String password;
    private String name;
    private Long age;

    @OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConsumerPrefer> consumerPrefers;


}
