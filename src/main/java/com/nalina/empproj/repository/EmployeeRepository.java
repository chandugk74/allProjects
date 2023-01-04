package com.nalina.empproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalina.empproj.entity.EmployeeEntity;
@Repository

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


}
