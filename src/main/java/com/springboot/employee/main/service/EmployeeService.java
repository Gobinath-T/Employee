package com.springboot.employee.main.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.employee.main.model.Employee;
import com.springboot.employee.main.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getDetails() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeId(int id) {
		return employeeRepository.findById(id).get();
		 
	}
	
	public Employee getEmployeeByName(String name) {
		List<Employee> ansList = new ArrayList<Employee>(employeeRepository.findAll());
		Employee result=null;
		for(Employee i:ansList) {
			if(i.getFirstName().equalsIgnoreCase(name)) {
				result=i;
			}
		}
		return result;
	}
	
	
	  public String deleteId(int id) {
		  String result="User not found";
		  if(id<maxId() && id>0) 
		  {
			  employeeRepository.deleteById(id); 
			  result = "Deleted Sucessfully..."; 
			  } 
		  return result;
		  
		  }
	  
	  
	  
	  public Employee saveuser(Employee saveEmployee) {
		  Employee emp = new Employee();
		  emp.setId(maxId());
		  emp.setFirstName(saveEmployee.getFirstName());
		  emp.setLastName(saveEmployee.getLastName());
		  emp.setAge(saveEmployee.getAge());
		  
		  Employee saveemp = employeeRepository.save(emp);
		return saveemp;
		  
	  }

	private int maxId() {
		int maxEmpId = 0;
		for(Employee i:employeeRepository.findAll()) {
			maxEmpId=i.getId();
		}
		return maxEmpId+1;
	}
	
	public Employee updateEmployee(Employee empl) {
		
		Employee emp = employeeRepository.findById(empl.getId()).get();
		emp.setAge(empl.getId());
		emp.setFirstName(empl.getFirstName());
		emp.setLastName(empl.getLastName());
		emp.setAge(empl.getAge());
		employeeRepository.save(emp);
		return emp;
	}
	 
	
	

}
