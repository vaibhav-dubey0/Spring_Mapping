package com.example.namo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    Optional<User> findById(int id);
}

