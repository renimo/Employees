package com.employees_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeesValidator {  //TODO UT
    private final EmployeesRepository employeesRepository;
    //context
    @Autowired
    public EmployeesValidator(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public boolean validateNotExist(List<Employee> employeeList) {
        List<String > existingEmployeeIds = employeesRepository.findAll().stream()   //i can get just the Ids from DB
                .map(Employee::getId)
                .collect(Collectors.toList());

        return employeeList.stream().noneMatch(employee -> existingEmployeeIds.contains(employee.getId()));
    }

}
