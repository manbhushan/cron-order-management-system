package com.app.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Customer;
import com.app.Entity.Order;
import com.app.Repository.CustomerRepository;
import com.app.Repository.OrderRepository;

@Service
public class OrderService {
  
  @Autowired
  private CustomerRepository customerRepository;
  
  @Autowired
  private OrderRepository orderRepository;
  
  public Order createOrder(Long customerId, Order order) {
    Customer customer = customerRepository.findById(customerId).orElse(null);
    if (customer != null) {
      switch (customer.getCustomerType()) {
        case GOLD:
          order.setDiscountAmount(order.getDiscountAmount() * 0.1);
          break;
        case PLATINUM:
          order.setDiscountAmount(order.getDiscountAmount() * 0.2);
          break;
        default:
          break;
      }
      order.setId(customerId);
      order.setOrderDate(LocalDateTime.now());
      order = orderRepository.save(order);
    }
    return order;
  }
  
}
