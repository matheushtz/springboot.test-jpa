package com.mazin.cursinho.services;

//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.mazin.cursinho.entities.User;
import com.mazin.cursinho.repositories.UserRepository;
import com.mazin.cursinho.services.exceptions.ResourceDeletionBlocked;
import com.mazin.cursinho.services.exceptions.ResourceNotFoundException;
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
        //throw exception if user not found
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //method to insert a new User
    public User insert(User obj){
        return userRepository.save(obj);
    }

    //method to delete a User by id
    public void delete(Long id){
        findById(id); // throws ResourceNotFoundException if user doesn't exist
        try{ 
            userRepository.deleteById(id);
        } catch(DataIntegrityViolationException e){
            throw new ResourceDeletionBlocked(id);
        }
    }

    //method to update a User
    public User update(Long id, User obj){
        findById(id); // throws ResourceNotFoundException if user doesn't exist
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
