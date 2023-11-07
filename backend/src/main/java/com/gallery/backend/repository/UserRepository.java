package com.gallery.backend.repository;

import com.gallery.backend.domain.Users;
import com.gallery.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    //User findByUserIdAndPassword(String userId, String password);
    Users findByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);
    boolean existsUsersByEmail(String email);
}
