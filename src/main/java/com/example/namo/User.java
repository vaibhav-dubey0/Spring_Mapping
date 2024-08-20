package com.example.namo;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=4,message = " Name should have atleast 4 charactor present ")
    @JsonProperty("naam batao")
    private String name;
    private int age;
    @Size(min = 6)
    private String password;  // Corrected the typo

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
  
    public User(int id, @Size(min = 4, message = " Name should have atleast 4 charactor present ") String name, int age,
            @Size(min = 6) String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
       
    }
    public User() {
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password 
                + "]";
    }

    

    
}


