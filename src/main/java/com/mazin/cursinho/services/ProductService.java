package com.mazin.cursinho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.mazin.cursinho.entities.Product;
import com.mazin.cursinho.repositories.ProductRepository;

import java.lang.Long;


@Service //registering the class as a Spring service component
public class ProductService {

    @Autowired //dependency injection
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();   
    }

}
