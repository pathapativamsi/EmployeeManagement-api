package com.dailycodebuffer.employeemanagementapi.service;

import com.dailycodebuffer.employeemanagementapi.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    boolean deleteEmployee(long id);

    Employee getEmployeeById(long id);

    Employee updateEmployee(long id, Employee employee);
}
