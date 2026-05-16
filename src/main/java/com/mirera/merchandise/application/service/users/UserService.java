package com.mirera.merchandise.application.service.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mirera.merchandise.application.helper.PasswordValidator;
import com.mirera.merchandise.application.port.inbound.users.UserUseCase;
import com.mirera.merchandise.application.port.inbound.users.dto.request.UserCreateReqDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.request.UserUpdateReqDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.response.UserPageResDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.response.UserResDTO;
import com.mirera.merchandise.application.port.outbound.users.UserRepository;
import com.mirera.merchandise.domain.users.UsersEntity;

@Service
public class UserService implements UserUseCase {
  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserPageResDTO getAllUsers(Pageable pageable) {
    Page<UsersEntity> response = userRepo.findAllUsers(pageable);

    if (response == null || response.getContent().isEmpty()) {
      throw new IllegalArgumentException("Không có người dùng nào.");
    }

    List<UserResDTO> user = response.getContent().stream()
        .map(u -> new UserResDTO(
            u.getId(),
            u.getEmail(),
            u.getUsername(),
            u.getFull_name(),
            u.getPhone_number(),
            u.getAddress(),
            u.getStatus(),
            u.getCreatedAt(),
            u.getUpdatedAt()
        )).toList();

    return new UserPageResDTO(
      response.getNumber(),
      response.getSize(),
      response.getTotalPages(),
      response.getTotalElements(),
      user
    );
  }

  @Override
  public UserResDTO getUserById(int id) {
    UsersEntity user = existsUserById(id);

    return new UserResDTO(
      user.getId(),
      user.getEmail(),
      user.getUsername(),
      user.getFull_name(),
      user.getPhone_number(),
      user.getAddress(),
      user.getStatus(),
      user.getCreatedAt(),
      user.getUpdatedAt()
    );
  }

  @Override
  public void createUser(UserCreateReqDTO user) {
    isExistsByEmail(user.email());
    isExistsByUsername(user.username());
    validatePassword(user.password());

    userRepo.saveUser(new UsersEntity(
      user.email(),
      user.username(),
      user.full_name(),
      passwordEncoder.encode(user.password()),
      user.role(),
      user.address(),
      user.phone_number()
    ));
  }

  @Override
  public void updateUser(int id, UserUpdateReqDTO user) {
    UsersEntity existingUser = existsUserById(id);

    validatePassword(user.password());

    existingUser.setEmail(user.email());
    existingUser.setUsername(user.username());
    existingUser.setFull_name(user.full_name());
    existingUser.setPassword(passwordEncoder.encode(user.password()));
    existingUser.setRole(user.role());
    existingUser.setAddress(user.address());
    existingUser.setPhone_number(user.phone_number());

    userRepo.saveUser(existingUser);
  }

  @Override
  public void softDeleteUser(int id) {
    UsersEntity user = existsUserById(id);

    if (user.getStatus() == true) {
      user.setStatus(false);
    } else user.setStatus(true);
    userRepo.saveUser(user);
  }

  @Override
  public void deleteUserById(int id) {
    existsUserById(id);
    
    userRepo.deleteUserById(id);
  }

  public void isExistsByEmail(String email) {
    if (userRepo.existsByEmail(email)) {
      throw new IllegalArgumentException("Email này đã được đăng ký");
    }
  }

  public void isExistsByUsername(String username) {
    if (userRepo.existsByUsername(username)) {
      throw new IllegalArgumentException("Username này đã được sử dụng");
    }
  }

  public UsersEntity existsUserById(int id) {
    UsersEntity user = userRepo.findUserById(id);
    if (user == null) {
      throw new IllegalArgumentException("Người dùng không tồn tại");
    }
    return user;
  }

  public void validatePassword(String password) {
    if (!PasswordValidator.isValid(password)) {
      throw new IllegalArgumentException(PasswordValidator.getPasswordRequirements());
    }
  }
}