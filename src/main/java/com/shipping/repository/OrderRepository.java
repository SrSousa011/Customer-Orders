package com.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
