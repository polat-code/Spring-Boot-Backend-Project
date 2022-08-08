package com.example.springbootbackendproject.service;

import com.example.springbootbackendproject.entity.Department;
import com.example.springbootbackendproject.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    Department department;

    @BeforeEach
    void setUp() {
        List<Department> departmentList = new ArrayList<>();
        department = new Department().builder()
                .departmentName("department11")
                .departmentAddress("department112")
                .departmentCode("swd-122")
                .build();
        departmentList.add(department);
        Mockito.when(departmentRepository.findByDepartmentName("department11")).thenReturn(departmentList);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "department11";
        List<Department> actual = departmentService.findDepartmentByName("department11");
        List<Department> expected = new ArrayList<>();
        expected.add(department);
        assertEquals(expected,actual);

    }
}