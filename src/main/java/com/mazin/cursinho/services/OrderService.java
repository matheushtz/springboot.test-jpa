package com.mazin.cursinho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.mazin.cursinho.entities.Order;
import com.mazin.cursinho.repositories.OrderRepository;

import java.lang.Long;


@Service //registering the class as a Spring service component
public class OrderService {

    @Autowired //dependency injection
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();   
    }

}
