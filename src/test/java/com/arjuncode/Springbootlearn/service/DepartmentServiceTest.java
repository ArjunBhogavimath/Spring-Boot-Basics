package com.arjuncode.Springbootlearn.service;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//THIS WILL TELL SPRING BOOT THAT THIS IS TEST CLASS
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    //we need to mock department Repository so create a object of Deprartment repository


    @MockBean //this is used to mock
    private DepartmentRepository departmentRepository;

    //for every method this setup() will call before
    //@BeforeAll --> this will call only once for all the methods.
    @BeforeEach
     void setUp(){
        Department department = Department.builder()
                .departmentName("AI")
                .departmentAddress("BENGLURU")
                .departmentCode("CS-01")
                .departmentId(1L)
                .build();

        //need to specify when this object needs to be passed so we are mentioning when
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("AI"))
                .thenReturn(department);
    }

    //we need the department name to get the we need to call the methods in departmentservice.java
    //to do that at first we need to autowire that class
    @Test //we need to annotate the method with test so we can use this as a test function
   @DisplayName("get Data Based on valid department name")
   @Disabled //this is used for disabling particualr test case
   public void whenValidDepartmentName_thenDepartmentShouldFound(){ //the naming of the method should be standard please read spring doc
        String departmentName = "AI";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        //thsi assertEquals will try to match both
        assertEquals(departmentName, found.getDepartmentName());
    }
}




