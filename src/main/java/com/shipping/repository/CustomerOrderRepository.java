package com.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.entity.ShippingCard;

@Repository
public interface CustomerOrderRepository extends JpaRepository<ShippingCard,Integer> {
    
}
