package org.example.demo.elasicsearchdemo.service;


import lombok.RequiredArgsConstructor;
import org.example.demo.elasicsearchdemo.enities.Employee;
import org.example.demo.elasicsearchdemo.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EmployeeRepositoryService {

    private final EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee getEmployee(String employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        return employeeOptional.orElse(null);
    }

    public List<Employee> searchEmployeeWithSalaryBetween(long startingSalary, long endingSalary) {
        return employeeRepository.findBySalaryBetween(startingSalary, endingSalary);
    }

    public List<Employee> searchSalaryQuery(Long salary) {

        Pageable pageable = PageRequest.of(0,10, Sort.by("salary"));
        return employeeRepository.findBySalary(salary, pageable).getContent();
    }

    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> getEmployeeUsingScroll(Long salary) {

        Stream<Employee> stream = employeeRepository.findAllBySalary(salary);

        List<Employee> employees = stream.toList();
        stream.close();
        return employees;
    }
}
