package com.example.whenbrella.domain.user.repository;

import com.example.whenbrella.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Class Diagram에 표시해주기 위해 기본 메소드들도 작성함.
    boolean existsById(String username);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String userName);

    boolean existsByUsername(String username);

}
