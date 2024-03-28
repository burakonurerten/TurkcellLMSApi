package com.turkcell.spring.intro.services.abstracts;

import java.util.List;
import com.turkcell.spring.intro.dtos.EmployeeDTO;
import com.turkcell.spring.intro.entities.*;

public interface EmployeeService {
    void add(EmployeeDTO employee);
    void update(Employee employee);
    void delete(int id);
    Employee getById(int id);
    List<Employee> getAll();
}
