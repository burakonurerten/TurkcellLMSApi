package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
