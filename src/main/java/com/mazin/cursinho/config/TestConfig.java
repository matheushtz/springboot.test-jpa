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
import com.mazin.cursinho.repositories.ProductRepository;
import com.mazin.cursinho.entities.Product;

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

    @Autowired
    private ProductRepository productRepository;

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

        Product p1 = new Product(null, "The Lord of the Rings", 90.5, "A fantasy novel", "image1.jpg");
        Product p2 = new Product(null, "Smart TV", 2190.0, "A 50-inch smart TV", "image2.jpg");
        Product p3 = new Product(null, "Macbook Pro", 1250.0, "A laptop from Apple", "image3.jpg");
        Product p4 = new Product(null, "PC Gamer", 1200.0, "A gaming PC", "image4.jpg");
        Product p5 = new Product(null, "Rails for Dummies", 100.99, "A book on Rails", "image5.jpg");

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}
