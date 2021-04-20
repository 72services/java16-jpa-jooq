package com.demo;

import com.demo.dto.EmployeeDTO;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.demo.database.tables.Department.DEPARTMENT;
import static com.demo.database.tables.Employee.EMPLOYEE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class JooqTest {

    @Autowired
    private DSLContext dsl;

    @Test
    void findAllEmployees() {
        List<EmployeeDTO> employees = dsl
                .select(EMPLOYEE.NAME, DEPARTMENT.NAME)
                .from(EMPLOYEE).join(DEPARTMENT).on(EMPLOYEE.DEPARTMENT_ID.eq(DEPARTMENT.ID))
                .fetchInto(EmployeeDTO.class);

        assertEquals(1, employees.size());
    }
}
