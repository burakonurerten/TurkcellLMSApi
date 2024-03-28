package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.dtos.UserDTO;
import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    
    @GetMapping("/getById/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }
    
    @PutMapping("/update")
    public void updateUser(@RequestBody User newUser){
        userService.update(newUser);
    }
    
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.delete(userId);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserDTO user){
        userService.add(user);
    }
}
