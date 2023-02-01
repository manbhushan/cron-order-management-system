package com.app.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "customer_id",nullable = false)
  private Customer customer;
  
  @Column(name = "order_date")
  private LocalDateTime orderDate;
  
  @Column(name = "discount_amount")
  private Double discountAmount;
  
  public Order() {
    // default constructor
  }
  
  public Order(Customer customer, LocalDateTime orderDate, Double discountAmount) {
    this.customer = customer;
    this.orderDate = orderDate;
    this.discountAmount = discountAmount;
  }
  
  // Getters and Setters
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Customer getCustomer() {
    return customer;
  }
  
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  
  public LocalDateTime getOrderDate() {
    return orderDate;
  }
  
  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }
  
  public Double getDiscountAmount() {
    return discountAmount;
  }
  
  public void setDiscountAmount(Double discountAmount) {
    this.discountAmount = discountAmount;
  }
  
}