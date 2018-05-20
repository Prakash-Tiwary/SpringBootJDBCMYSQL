package com.springboot.springboot.Dao;

import com.springboot.springboot.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Integer id);

    public void addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee) ;
}
