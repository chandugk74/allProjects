package com.nalina.empproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nalina.empproj.dto.EmployeeDto;
import com.nalina.empproj.entity.EmployeeEntity;
import com.nalina.empproj.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
		return employeeService.insert(employeeDto);
	}
	
	@GetMapping
	public List<EmployeeEntity> getAllEmp() {
		return employeeService.fetchAll();
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getById(@PathVariable long id) {
		return employeeService.fetchById(id);
	}
	@PutMapping("/{id}")
	public EmployeeEntity UpdateEmpById(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.modifyEmp(employeeEntity);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		employeeService.deleteEmp(id);
	}

}
