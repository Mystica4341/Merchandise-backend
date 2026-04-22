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
  @Column(name = "full_name", nullable = true)
  private String full_name;

  @Column(name = "phone_number", nullable = true, unique = true)
  private String phone_number;

  @Column(name = "address", nullable = true)
  private String address;

  @Column(name = "username", nullable = true, unique = true)
  private String username;

  @Column(name = "email", nullable = true, unique = true)
  private String email;

  @Column(name = "password", nullable = true)
  private String password;

  @OneToMany(mappedBy = "user")
  private Set<OrdersEntity> orders = new HashSet<>();
  
  @Column(name = "status", nullable = true)
  private Boolean status = true;
  
  public UsersEntity(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }
}
