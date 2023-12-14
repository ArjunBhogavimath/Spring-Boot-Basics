package com.arjuncode.Springbootlearn.service;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
        //the entire findbyId will return optional
        //so to get the particular value we need to use.get
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        //this will get the particular department record from db

        //we need to implement methods to check where the change is
        //we are only checking if any field is null or empty
        //only if it is then only we are updating
        //we did this for all the 3 fields

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        //there is no default method to find by name
        //so we need to create a method to search by name in departmentRepository

       //return departmentRepository.findByDepartmentName(departmentName);

        //the above 1 is case sensetive, to avoid that
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

    }
}
