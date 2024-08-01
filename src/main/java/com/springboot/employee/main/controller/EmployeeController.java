package com.springboot.employee.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.main.model.Employee;
import com.springboot.employee.main.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmployeesDetails")
	public List<Employee> getEmployees() {
		return employeeService.getDetails();
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		
		try {
			
			Employee employeeRes = employeeService.getEmployeeId(id);
			return new ResponseEntity<>(employeeRes,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("User not found",HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Object> getByName(@PathVariable String name) {
		try {
			Employee resname = employeeService.getEmployeeByName(name);
			if(resname!=null) {
				return new ResponseEntity<>(resname,HttpStatus.OK);
				
			}
			else {
				return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);}
			
		}catch(Exception e) {
			return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/nameByReq")
	public ResponseEntity<Object> getByNameReq(@RequestParam String name) {
		
		try {
			
			Employee resByName = employeeService.getEmployeeByName(name);
			if(resByName!=null) {
			return new ResponseEntity<>(resByName,HttpStatus.OK);}
			else {
				return new ResponseEntity<>("User is not present...",HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>("User is not present...",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	  @DeleteMapping("/delete/{id}") 
	  public ResponseEntity<Object>deleteEmployee(@PathVariable int id) {
	  
	  try { 
	  String resdelete = employeeService.deleteId(id); 
	  return new ResponseEntity<>(resdelete,HttpStatus.OK); }
	  catch(Exception e)
	  { 
		  return new ResponseEntity<>("User not found...",HttpStatus.NOT_FOUND); 
		  }
	  
	  }
	  
	  @PostMapping("/save")
	  public Employee saveuser(@RequestBody Employee saveEmployee) {
		return employeeService.saveuser(saveEmployee);
		 
		  
	  }
	  
	  
	  @PutMapping("/upadate")
	  public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		  try {
			  Employee emp = employeeService.updateEmployee(employee);
			  return new ResponseEntity<>(emp,HttpStatus.OK);
		  }catch(Exception e) {
			  return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
		  }
		 
		
	  }
	 
	
}




