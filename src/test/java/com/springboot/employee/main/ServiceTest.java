package com.springboot.employee.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.springboot.employee.main.model.Employee;
import com.springboot.employee.main.repository.EmployeeRepository;
import com.springboot.employee.main.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private EmployeeRepository emprepo;

    @InjectMocks
    private EmployeeService empService;

    @Test
    public void test_getDetails() {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "Rock", "Johnson", 30));
        emp.add(new Employee(2, "John", "Cena", 52));
        emp.add(new Employee(3, "Cody", "Rhodes", 40));
        
        // Mock the repository call
        when(emprepo.findAll()).thenReturn(emp);
        
        // Test the service method
        List<Employee> employees = empService.getDetails();
        
        // Verify the result
        assertEquals(3, empService.getDetails().size(), "The number of employees should be 3");
    }
}
