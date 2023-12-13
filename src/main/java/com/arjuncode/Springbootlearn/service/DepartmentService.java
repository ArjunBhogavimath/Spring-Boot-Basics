package com.arjuncode.Springbootlearn.service;

import com.arjuncode.Springbootlearn.entity.Department;

import java.util.List;

public interface DepartmentService {


    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();
}
