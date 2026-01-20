package com.mazin.cursinho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.mazin.cursinho.entities.Category;
import com.mazin.cursinho.repositories.CategoryRepository;

import java.lang.Long;


@Service //registering the class as a Spring service component
public class CategoryService {

    @Autowired //dependency injection
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();   
    }

}
