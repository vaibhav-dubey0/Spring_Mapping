package com.example.namo.configurationcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.namo.Service;
import com.example.namo.User;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
public class ConfigController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Service service;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/user/{id}")
    public EntityModel<User> getUserById(@PathVariable("id") int id) {
        User u = service.getUserById(id);
        if (u == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        EntityModel<User> em = EntityModel.of(u);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        em.add(link.withRel("all-users"));
        return em;
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody User u) {
        try {
            User ur = service.addUser(u);
            return ResponseEntity.status(HttpStatus.CREATED).body(ur);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User u, @PathVariable("id") int id) {
        try {
            service.updateUser(u, id);
            return ResponseEntity.ok(u);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        try {
            service.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

        @GetMapping("/user-international")
    public String getMessage() {
        Locale locale=LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message ", locale);

    }
    
}



