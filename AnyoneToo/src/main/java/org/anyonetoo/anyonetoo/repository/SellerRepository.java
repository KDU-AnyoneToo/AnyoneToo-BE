package org.anyonetoo.anyonetoo.repository;

import org.anyonetoo.anyonetoo.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findById(Long id);
}