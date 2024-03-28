package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.dtos.EmployeeDTO;
import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.services.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    
    @GetMapping("/getById/{id}")
    public Employee getById(@PathVariable int id){
        return employeeService.getById(id);
    }
    
    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee newEmployee){
        employeeService.update(newEmployee);
    }
    
    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
    }
    
    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody EmployeeDTO employee){
        employeeService.add(employee);
    }
}
