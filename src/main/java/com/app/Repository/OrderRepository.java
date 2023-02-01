package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByCustomer_id(Long customerId);

}
