package com.arjuncode.Springbootlearn.service;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this is service implementation
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired //created object of DepartmentRepository
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }
}
