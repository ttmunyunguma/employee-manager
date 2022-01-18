package com.example.employeemanager.service;

import com.example.employeemanager.entity.Employee;
import com.example.employeemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).get();
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee, Integer id){
        try {
            Employee employeeToBeUpdated = getEmployeeById(id);
            employeeToBeUpdated = employee;
            employeeToBeUpdated.setId(id);
            return employeeRepository.save(employeeToBeUpdated);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void deleteEmployee(Integer id){
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
