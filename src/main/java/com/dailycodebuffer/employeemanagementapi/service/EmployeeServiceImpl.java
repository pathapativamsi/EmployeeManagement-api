package com.dailycodebuffer.employeemanagementapi.service;

import com.dailycodebuffer.employeemanagementapi.entity.EmployeeEntity;
import com.dailycodebuffer.employeemanagementapi.models.Employee;
import com.dailycodebuffer.employeemanagementapi.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream()
                .map(emp -> new Employee(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmailId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        Employee emp = new Employee();
        BeanUtils.copyProperties(employee,emp);
        return emp;
    }

    @Override
    public Employee updateEmployee(long id,Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
