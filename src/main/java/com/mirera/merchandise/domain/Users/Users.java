package com.mirera.merchandise.domain.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Users {
  private Integer userId;
  private String fullname;
  private String phone;
  private String address;
  private String email;
  private String username;
  private String password;

  public Users(Integer userId, String fullname, String phone, String address, String email,
      String username, String password) {
    this.userId = userId;
    this.fullname = fullname;
    this.phone = phone;
    this.address = address;
    this.email = email;
    this.username = username;
    this.password = password;
  }

  // Register User
  public Users(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public void changePassword(String newPassword) {
    validPassword(newPassword);
    this.password = newPassword;
  }

  public void validPassword(String inputPassword) {
    if (inputPassword == null || inputPassword.trim().isEmpty()) {
      throw new IllegalArgumentException("Mật khẩu không được để trống.");
    }
    if (inputPassword.length() <= 8) {
      throw new IllegalArgumentException("Mật khẩu phải dài hơn 8 ký tự.");
    }
    if (!inputPassword.matches(".*[A-Z].*")) {
      throw new IllegalArgumentException("Mật khẩu phải chứa ít nhất 1 chữ cái viết hoa.");
    }
    if (!inputPassword.matches(".*[^a-zA-Z0-9].*")) {
      throw new IllegalArgumentException("Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt.");
    }
  }
}
