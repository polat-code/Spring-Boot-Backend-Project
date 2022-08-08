package com.example.springbootbackendproject.service;

import com.example.springbootbackendproject.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchAllDepartments();

    Department getDepartmentById(Long id);

    void deleteDepartmentById(Long id);

    Department updateDepartmentById(Long departmentId, Department department) throws Exception;

    List<Department> findDepartmentByName(String departmentName);
}
