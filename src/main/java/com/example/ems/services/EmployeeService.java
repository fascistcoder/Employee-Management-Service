package com.example.ems.services;

import com.example.ems.model.Employee;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/10/21
 */
public interface EmployeeService {
    List<Employee>getAllEmployees();
}
