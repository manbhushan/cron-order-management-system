package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "customer")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "email",unique=true)
  private String email;
  
  @Column(name = "customer_type")
  @Enumerated(EnumType.STRING)
  private CustomerType customerType;
  
  public Customer() {
    // default constructor
  }
  
  public Customer(String name, String email, CustomerType customerType) {
    this.name = name;
    this.email = email;
    this.customerType = customerType;
  }
  
  // Getters and Setters
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public CustomerType getCustomerType() {
    return customerType;
  }
  
  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }
  
}


