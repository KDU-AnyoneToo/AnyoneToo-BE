package org.anyonetoo.anyonetoo.repository;

import org.anyonetoo.anyonetoo.domain.Seller;
import org.anyonetoo.anyonetoo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findById(String id);
}
