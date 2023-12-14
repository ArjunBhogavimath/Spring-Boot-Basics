package com.arjuncode.Springbootlearn.controller;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.service.DepartmentService;
import com.arjuncode.Springbootlearn.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //Here we need whole department list so we are returning list
    public List<Department> fetchDepartmentList(){
      return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}") //id is a path variable and  dynamic
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        //by declaring as @PathVariable annotation we are mapping id to departmentId
         return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!!!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
}
