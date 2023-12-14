package com.arjuncode.Springbootlearn.service;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {


    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
