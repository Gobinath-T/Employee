package com.springboot.employee.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employee.main.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
