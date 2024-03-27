package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.repositories.BookRepository;
import com.turkcell.spring.intro.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    
    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable int id){
        User user = userRepository.findById(id).orElse(null);
        
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public User updateBook(@RequestBody User newUser){
        return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.OK).getBody();
    }
    
    @DeleteMapping("/delete/{userId}")
    public void deleteBook(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody User user){
        userRepository.save(user);
    }
}
