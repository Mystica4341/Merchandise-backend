package com.mirera.merchandise.infrastructure.repository.users;

import java.util.List;

import com.mirera.merchandise.application.port.outbound.users.UserRepository;
import com.mirera.merchandise.domain.users.UsersEntity;

public class UserRepositoryAdapter implements UserRepository {
  private final UserJpaRepository userJpaRepository;

  public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
    this.userJpaRepository = userJpaRepository;
  }

  @Override
  public List<UsersEntity> findAll() {
    return userJpaRepository.findAll();
  }

  @Override
  public UsersEntity findUserById(int userId) {
    return userJpaRepository.findById(userId).orElse(null);
  }

  @Override
  public UsersEntity findByEmail(String email) {
    return userJpaRepository.findByEmail(email).orElse(null);
  }

  @Override
  public void saveUser(UsersEntity user) {
    userJpaRepository.save(user);
  }

  @Override
  public void deleteUserById(int userId) {
    userJpaRepository.deleteById(userId);
  }

  @Override
  public boolean existsByEmail(String email) {
    return userJpaRepository.existsByEmail(email);
  }

  @Override
  public boolean existsByUsername(String username) {
    return userJpaRepository.existsByUsername(username) ;
  }

}