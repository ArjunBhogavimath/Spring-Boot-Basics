package com.arjuncode.Springbootlearn.controller;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.error.DepartmentNotFoundException;
import com.arjuncode.Springbootlearn.service.DepartmentService;
import com.arjuncode.Springbootlearn.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired //get the autowire this object from this reference
    private DepartmentService departmentService;

    //this is sl4j Logger class
    private final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    //using getLoger I'm getting the departmentcontroller class

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){ //request body get the JSON and convert it to department object
        log.info("Inside DepartmentController save method!!!!!!!!!!!!!!!");
        return departmentService.saveDepartment(department);
        //DepartmentService service = new DepartmentServiceImpl();
        // this is a manual way of creating object using new keyword. but we can doi it easily with Spring-boot
    }

    //This is a get method
    @GetMapping("/departments")
    //Here we need whole department list so we are returning list
    public List<Department> fetchDepartmentList(){
        log.info("Inside DepartmentController get method!!!!!!!!!!!!!!!");

        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}") //id is a path variable and  dynamic
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        log.info("Inside DepartmentController get by ID method!!!!!!!!!!!!!!!");

        //by declaring as @PathVariable annotation we are mapping id to departmentId
         return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside DepartmentController DELETE by ID method!!!!!!!!!!!!!!!");

        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!!!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        log.info("Inside DepartmentController UPDATE by ID method!!!!!!!!!!!!!!!");

        return departmentService.updateDepartment(departmentId, department);
    }

    //This is for get department by name
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
