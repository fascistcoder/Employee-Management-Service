package com.example.ems.controller;

import com.example.ems.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/10/21
 */

class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    EmployeeController employeeController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        employeeController = new EmployeeController(employeeService);

        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void viewHomePage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("listEmployees"));
    }

    @Test
    void showEmployeeForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/showNewEmployeeForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_employee"))
                .andExpect(model().attributeExists("employee"));
    }

    @Test
    void saveEmployee() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/saveEmployee"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }
}