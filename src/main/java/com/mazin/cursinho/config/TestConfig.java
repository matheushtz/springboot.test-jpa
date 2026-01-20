package com.mazin.cursinho.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mazin.cursinho.repositories.CategoryRepository;
import com.mazin.cursinho.repositories.OrderRepository;
import com.mazin.cursinho.repositories.UserRepository;
import com.mazin.cursinho.entities.Order;
import com.mazin.cursinho.entities.User;
import com.mazin.cursinho.entities.OrderStatus;
import com.mazin.cursinho.entities.Category;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //autowiring the UserRepository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Code to run at startup for the "test" profile
        
        User u1 = new User(null, "Clara", "clara@gmail.com", "123456789", "password1");
        User u2 = new User(null, "Miguel", "miguel@gmail.com", "987654321", "password2");
        
        Order o1 = new Order(null, Instant.parse("2026-01-20T01:53:08Z"), OrderStatus.PROCESSING, u1);
        Order o2 = new Order(null, Instant.parse("2026-01-20T02:53:08Z"), OrderStatus.PROCESSING, u2);
        Order o3 = new Order(null, Instant.parse("2026-01-20T03:53:08Z"), OrderStatus.PENDING_PAYMENT, u1);
        
        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
