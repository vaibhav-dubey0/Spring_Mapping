package com.example.namo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    public User getUserById(int id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User addUser(User u) {
        return userRepo.save(u);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public void updateUser(User u, int id) {
        u.setId(id);
        userRepo.save(u);
    }
}


