package bits.org.mtech.ecomuser.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "public.user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;
  private String userName;
  private String userAddress;
  private String userPhoneNumber;

  @Transient
  private List<Order> orders = new ArrayList<>();

  public User() {
  }

  public User(String name, String address, String phoneNumber) {
    this.userAddress = address;
    this.userName = name;
    this.userPhoneNumber = phoneNumber;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public String getUserPhoneNumber() {
    return userPhoneNumber;
  }

  public void setUserPhoneNumber(String userPhoneNumber) {
    this.userPhoneNumber = userPhoneNumber;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}

