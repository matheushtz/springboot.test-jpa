package com.mazin.cursinho.repositories;

import com.mazin.cursinho.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mazin.cursinho.entities.pk.OrderItemPK;

@Repository //indicates that this interface is a Spring Data repository (opcional with JpaRepository)
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

    // No additional methods needed for basic CRUD operations
}
