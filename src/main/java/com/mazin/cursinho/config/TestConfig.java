package com.mazin.cursinho.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mazin.cursinho.repositories.UserRepository;
import com.mazin.cursinho.entities.User;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //autowiring the UserRepository
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Code to run at startup for the "test" profile

        User u1 = new User(null, "Maria", "maria@gmail.com", "123456789", "password1");
        User u2 = new User(null, "Alex", "alex@gmail.com", "987654321", "password2");
        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
