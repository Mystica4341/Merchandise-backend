package com.mirera.merchandise.domain.users;

import java.util.HashSet;
import java.util.Set;

import com.mirera.merchandise.domain.entity.BaseEntity;
import com.mirera.merchandise.domain.orders.OrdersEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class UsersEntity extends BaseEntity {
  @Column(name = "full_name")
  private String full_name;

  @Column(name = "phone_number", unique = true)
  private String phone_number;

  @Column(name = "address")
  private String address;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @OneToMany(mappedBy = "user")
  private Set<OrdersEntity> orders = new HashSet<>();
  
  @Column(name = "status")
  private Boolean status = true;

  @Column(name = "role", nullable = false)
  private String role = "USER";
  
  public UsersEntity(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public UsersEntity(String email, String username, String full_name, String password, String role, String address, String phone_number) {
    this.email = email;
    this.username = username;
    this.full_name = full_name;
    this.password = password;
    this.role = role;
    this.address = address;
    this.phone_number = phone_number;
  }
}
