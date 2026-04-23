package com.mirera.merchandise.application.helper;

import java.util.regex.Pattern;

public class PasswordValidator {
  private static final Pattern PASSWORD_PATTERN = Pattern.compile(
    "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{6,}$"
  );

  public static boolean isValid(String password) {
    if (password == null || password.isEmpty()) {
      return false;
    }
    return PASSWORD_PATTERN.matcher(password).matches();
  }

  public static String getPasswordRequirements() {
    return "Mật khẩu phải có ít nhất 6 ký tự, 1 chữ in hoa, 1 chữ số, và 1 ký tự đặc biệt.";
  }

}
