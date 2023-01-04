package com.nalina.empproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalina.empproj.dto.EmployeeDto;
import com.nalina.empproj.entity.EmployeeEntity;
import com.nalina.empproj.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeDto insert(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setAge(employeeDto.getAge());
		employeeEntity.setName(employeeDto.getName());
		employeeRepository.save(employeeEntity);
		employeeDto.setId(employeeEntity.getId());
		return employeeDto;
	}
	public List<EmployeeEntity> fetchAll() {
		return employeeRepository.findAll();
	}
	public EmployeeDto fetchById(long id) {
		Optional<EmployeeEntity> byId = employeeRepository.findById(id);
		if(byId.isPresent()) {
			EmployeeEntity row = byId.get();
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setAge(row.getAge());
			employeeDto.setName(row.getName());
			employeeDto.setId(row.getId());
			return employeeDto;
		}
		return null;
	}
	public EmployeeEntity modifyEmp(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}
	public void deleteEmp(long id) {
		employeeRepository.deleteById(id);
	}
	
}
