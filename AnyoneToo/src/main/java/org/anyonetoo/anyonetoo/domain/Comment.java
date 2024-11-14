package org.anyonetoo.anyonetoo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.anyonetoo.anyonetoo.domain.common.BaseEntity;

import java.util.List;

@Getter
@Entity
@Builder
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}
