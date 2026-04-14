package com.mirera.merchandise.infrastructure.repository.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirera.merchandise.domain.users.UsersEntity;

public interface UserJpaRepository extends JpaRepository<UsersEntity, Integer> {

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);

  Optional<UsersEntity> findByEmail(String email);
}