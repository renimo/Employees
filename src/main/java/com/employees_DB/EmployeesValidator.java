package com.employees_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeesValidator {  //TODO UT
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesValidator(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public boolean validateNotExist(List<Employee> employeeList) {
        List<String> existingEmployeeIds = existingEmployeesIds();
        return employeeList.stream().noneMatch(employee -> existingEmployeeIds.contains(employee.getId()));
    }

    public boolean validateIdExist(String id){
        List<String> existingEmployeeIds = existingEmployeesIds();

        return existingEmployeeIds.contains(id);
    }

    public List<String> existingEmployeesIds(){
        return employeesRepository.findAll().stream().map(Employee::getId).collect(Collectors.toList());
    }

}
