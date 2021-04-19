package com.demo.repository;

import com.demo.dto.EmployeeDTO;
import com.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select new com.demo.dto.EmployeeDTO(e.name, e.department.name) from Employee e")
    List<EmployeeDTO> findAllEmployees();
}
