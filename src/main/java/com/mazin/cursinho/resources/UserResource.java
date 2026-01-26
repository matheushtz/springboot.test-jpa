package com.mazin.cursinho.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazin.cursinho.entities.User;
import com.mazin.cursinho.services.UserService;


import java.util.List;
import java.lang.Long;
import java.net.URI;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping //endpoint to get all users
    public ResponseEntity<List<User>> findall(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //endpoint to get user by id
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping //endpoint to insert a new User
    public ResponseEntity<User> insertUser (@RequestBody User obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        //HTTP response 201 ao criar o usuario
        return ResponseEntity.created(uri).body(obj);

        //HTTP response 200 ao criar o usuario
        //return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.delete(id);
        
        //HTTP response 204 No Content
        return ResponseEntity.noContent().build();
    }
}
