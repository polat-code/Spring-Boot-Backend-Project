package com.example.springbootbackendproject.controller;

import com.example.springbootbackendproject.entity.Department;
import com.example.springbootbackendproject.service.DepartmentService;
import com.example.springbootbackendproject.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartments() {
        logger.info("FetchAllDepartments is running!");
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long id ) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                        @RequestBody Department department) throws Exception {
        return  departmentService.updateDepartmentById(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public List<Department> findDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.findDepartmentByName(departmentName);
    }

}
