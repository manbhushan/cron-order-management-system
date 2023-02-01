package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.Order;
import com.app.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  
  @Autowired
  private OrderService orderService;
  
  @PostMapping
  public ResponseEntity<Order> createOrder(@RequestParam Long customerId, @RequestBody Order order) {
    Order createdOrder = orderService.createOrder(customerId, order);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
  }

}
