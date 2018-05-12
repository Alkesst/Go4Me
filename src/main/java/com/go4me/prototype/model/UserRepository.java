package com.go4me.prototype.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByEmail(String email);
    User findByid(Long id);
    List<User> findByLocalization(Localization localization);
}
