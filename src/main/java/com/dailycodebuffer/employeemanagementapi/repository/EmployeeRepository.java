package com.dailycodebuffer.employeemanagementapi.repository;

import com.dailycodebuffer.employeemanagementapi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
