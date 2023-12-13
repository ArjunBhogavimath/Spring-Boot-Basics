package com.arjuncode.Springbootlearn.controller;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.service.DepartmentService;
import com.arjuncode.Springbootlearn.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired //get the autowire this object from this reference
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){ //request body get the JSON and convert it to department object
        return departmentService.saveDepartment(department);
        //DepartmentService service = new DepartmentServiceImpl();
        // this is a manual way of creating object using new keyword. but we can doi it easily with Spring-boot
    }

    //This is a get method
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
      return departmentService.fetchDepartmentList();
    }
}
