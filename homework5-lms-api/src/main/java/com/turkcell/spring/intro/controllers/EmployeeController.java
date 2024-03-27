package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    
    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        
        if (employee == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public Employee updateBook(@RequestBody Employee newEmployee){
        return new ResponseEntity<>(employeeRepository.save(newEmployee), HttpStatus.OK).getBody();
    }
    
    @DeleteMapping("/delete/{employeeId}")
    public void deleteBook(@PathVariable int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
    
    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }
}
