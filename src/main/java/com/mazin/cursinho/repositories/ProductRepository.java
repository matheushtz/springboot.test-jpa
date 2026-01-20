package com.mazin.cursinho.repositories;

import com.mazin.cursinho.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //indicates that this interface is a Spring Data repository (opcional with JpaRepository)
public interface ProductRepository extends JpaRepository<Product, Long> {

}
