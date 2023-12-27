package com.arjuncode.Springbootlearn.controller;

import com.arjuncode.Springbootlearn.entity.Department;
import com.arjuncode.Springbootlearn.error.DepartmentNotFoundException;
import com.arjuncode.Springbootlearn.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class) // we test endpoints in this class so we need this annotation
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;


    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Mangalore")
                .departmentCode("IT-05")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    @Disabled
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Mangalore")
                .departmentCode("IT-05")
                .departmentName("IT")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        //we need to call the endpoints from here

        mockMvc.perform(post("/departments")
                .content("{\n" +
                        "         \"departmentName\": \"IT\",\n" +
                        "        \"departmentAddress\": \"Mangalore\",\n" +
                        "        \"departmentCode\": \"IT-05\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    @Disabled
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentId()));
    }
}