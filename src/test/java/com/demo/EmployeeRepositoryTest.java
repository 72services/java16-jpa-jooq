package com.demo;

import com.demo.dto.EmployeeDTO;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findAllEmployees() {
        List<EmployeeDTO> employees = employeeRepository.findAllEmployees();

        assertEquals(1, employees.size());
    }
}
