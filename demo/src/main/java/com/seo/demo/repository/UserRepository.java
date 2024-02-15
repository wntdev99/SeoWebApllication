package com.seo.demo.repository;

import com.seo.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String username);
    List<User> findAll();

}
