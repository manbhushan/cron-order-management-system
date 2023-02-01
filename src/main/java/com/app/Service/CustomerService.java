package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Customer;
import com.app.Entity.CustomerType;
import com.app.Entity.Order;
import com.app.Repository.CustomerRepository;
import com.app.Repository.OrderRepository;

@Service
public class CustomerService {
  
  @Autowired
  private CustomerRepository customerRepository;
  
  @Autowired
  private OrderRepository orderRepository;
  
  public void promoteCustomer(Long customerId) {
    Customer customer = customerRepository.findById(customerId).orElse(null);
    if (customer != null) {
      List<Order> orders = orderRepository.findByCustomer_id(customerId);
      int numOfOrders = orders.size();
      if (numOfOrders >= 20) {
        customer.setCustomerType(CustomerType.PLATINUM);
      } else if (numOfOrders >= 10) {
        customer.setCustomerType(CustomerType.GOLD);
      }
      customerRepository.save(customer);
    }
  }
}
