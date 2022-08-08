package com.example.springbootbackendproject.service;

import com.example.springbootbackendproject.entity.Department;
import com.example.springbootbackendproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) throws Exception {
        Department dbDepartment = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(dbDepartment.getDepartmentName()) &&
                !"".equalsIgnoreCase(dbDepartment.getDepartmentName())) {
            dbDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(dbDepartment.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(dbDepartment.getDepartmentAddress())) {
            dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(dbDepartment.getDepartmentCode()) &&
                !"".equalsIgnoreCase(dbDepartment.getDepartmentCode())) {
            dbDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(dbDepartment);
    }

    @Override
    public List<Department> findDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
