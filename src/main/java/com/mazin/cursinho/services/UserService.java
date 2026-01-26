package com.mazin.cursinho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.mazin.cursinho.entities.User;
import com.mazin.cursinho.repositories.UserRepository;

import java.lang.Long;


@Service //registering the class as a Spring service component
public class UserService {

    @Autowired //dependency injection
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();   
    }

    //method to insert a new User
    public User insert(User obj){
        return userRepository.save(obj);
    }

    //method to delete a User by id
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    //method to update a User
    public User update(Long id, User obj){
        User entity = userRepository.findById(id).get();
        updateData(entity, obj); //helper method to update fields
        return userRepository.save(entity);
    }

    //helper method to update entity data
    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        //id is not updated to preserve entity identity
    }
}
