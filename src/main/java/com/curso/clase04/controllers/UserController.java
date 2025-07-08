package com.curso.clase04.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.clase04.entities.User;
import com.curso.clase04.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserbyId(id);
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }


}
