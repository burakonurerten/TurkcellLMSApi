package com.turkcell.spring.intro.services.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import com.turkcell.spring.intro.dtos.EmployeeDTO;
import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.repositories.*;
import com.turkcell.spring.intro.services.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    
    @Override
    public void add(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setName(employeeDTO.getName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeRepository.save(employee);
    }
    
    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }
    
    @Override
    public void delete(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee == null)
            throw new RuntimeException("There is no employee with this id: " + id);
        employeeRepository.delete(employee);
    }
    
    @Override
    public Employee getById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        
        if(employee == null)
            throw new RuntimeException("There is no employee with this id: " + id);
        
        return employee;
    }
    
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
