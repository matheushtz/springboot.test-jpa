package com.mazin.cursinho.repositories;

import com.mazin.cursinho.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
