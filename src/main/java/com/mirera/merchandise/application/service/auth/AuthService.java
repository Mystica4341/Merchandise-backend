package com.mirera.merchandise.application.service.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mirera.merchandise.application.helper.PasswordValidator;
import com.mirera.merchandise.application.port.inbound.auth.dto.response.LoginResDTO;
import com.mirera.merchandise.application.port.outbound.users.UserRepository;
import com.mirera.merchandise.domain.users.UsersEntity;
import com.mirera.merchandise.infrastructure.service.JwtServices;

@Service
public class AuthService {
  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;
  private final JwtServices JwtServices;

  public AuthService(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtServices jwtServices) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
    this.JwtServices = jwtServices;
  }

  public LoginResDTO authenticate(String account, String password) {
    boolean isEmail = account != null && account.matches("(?i)^.+\\.com$");

    UsersEntity userEntity = isEmail
        ? userRepo.findByEmail(account)
        : userRepo.findByUsername(account);

    if (userEntity == null) {
      throw new IllegalArgumentException("Tài Khoản hoặc mật khẩu không đúng");
    }

    verifyPassword(password, userEntity.getPassword());

    if (!userEntity.getStatus()) {
      throw new IllegalArgumentException("Tài khoản đã bị vô hiệu hóa");
    }

    return new LoginResDTO(
      userEntity.getId(), 
      userEntity.getEmail(),
      userEntity.getUsername(),
      userEntity.getRole(),
      JwtServices.generateToken(userEntity.getUsername(), userEntity.getRole())
    );
  }

  public void changePassword(int userId, String currentPassword, String newPassword) {
    UsersEntity user = userRepo.findUserById(userId);
    if (user == null) {
      throw new IllegalArgumentException("Tài khoản không tồn tại");
    }

    // Xác thực mật khẩu hiện tại
    verifyPassword(currentPassword, user.getPassword());

    if (!PasswordValidator.isValid(newPassword)) {
      throw new IllegalArgumentException(PasswordValidator.getPasswordRequirements());
    }

    user.setPassword(passwordEncoder.encode(newPassword));
    userRepo.saveUser(user);
  }

  public void register(String email, String username, String password) {
    if (userRepo.existsByEmail(email)) {
      throw new IllegalArgumentException("Email đã tồn tại");
    }

    if (userRepo.existsByUsername(username)) {
      throw new IllegalArgumentException("Tên đăng nhập đã tồn tại");
    }

    if (!PasswordValidator.isValid(password)) {
      throw new IllegalArgumentException(PasswordValidator.getPasswordRequirements());
    }

    UsersEntity newUser = new UsersEntity();
    newUser.setEmail(email);
    newUser.setUsername(username);
    newUser.setPassword(passwordEncoder.encode(password));

    userRepo.saveUser(newUser);
  }

  public void verifyPassword(String rawPassword, String encodedPassword) {
    if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
      throw new IllegalArgumentException("Tài Khoản hoặc mật khẩu không đúng");
    }
  }
}
