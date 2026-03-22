package com.mirera.merchandise.domain.model;

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

  public Integer getuserId() {
    return userId;
  }

  public String getfullname() {
    return fullname;
  }

  public String getphone() {
    return phone;
  }

  public String getaddress() {
    return address;
  }

  public String getemail() {
    return email;
  }

  public String getusername() {
    return username;
  }

  public String getpassword() {
    return password;
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

  public void encryptPassword() {
    // Testing encrypt sử dụng Base64
    this.password = java.util.Base64.getEncoder().encodeToString(this.password.getBytes());
  }
}
