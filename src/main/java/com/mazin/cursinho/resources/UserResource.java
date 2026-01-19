package com.mazin.cursinho.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mazin.cursinho.entities.User;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findall(){
        User u = new User(1L, "Matheus", "matheus@example.com", 
        "123456789", "password");
        return ResponseEntity.ok().body(u);

    }
}
