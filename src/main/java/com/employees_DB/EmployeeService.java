package com.employees_DB;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeesRepository employeesRepository; //Dependency Inversion
    private final EmployeesValidator employeesValidator;

    @Autowired //need a cons?
    public EmployeeService(EmployeesRepository employeesRepository, EmployeesValidator employeesValidator) {
        this.employeesRepository = employeesRepository;
        this.employeesValidator = employeesValidator;
    }

    public List<Employee> findAllEmployees() {
        return employeesRepository.findAll();
    }

    public List<String> findAllEmployeesEmails(){
        List<Employee> allEmployees = findAllEmployees();

        return allEmployees.stream().map(Employee::getEmail).collect(Collectors.toList());
    }

    public Employee findEmployeeFromId(String id){
        return employeesRepository.findFromId(id);
    }

    public void insertEmployee(List<Employee> employeeList) throws IOException {
        if(!employeesValidator.validateNotExist(employeeList)){
            System.out.println("One of the employees in the list already exist.");
        }
        //log this error using a logging framework like SLF4J and Logback
        //Keep in mind that this validation logic may have concurrency issues if multiple requests try to insert the same employee simultaneously.

        else{
            Double convertUSDToEuro = convertUSDToEuro();

            employeeList.forEach(employee -> employee.setSalary(convertUSDToEuro * employee.getSalary()));
            employeesRepository.saveAll(employeeList);

//            for (Employee employee: employeeList) {
                SendNotification.sendNotification(); //employeeList); //to send list of new employees /////////////
//            }
        }
    }

    /* If entities are already available in collection in MongoDB, then they will be updated.
    otherwise they will be inserted as new entities */
    public void updateEmployee(Employee employee){
        employeesRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        if(!employeesValidator.validateIdExist(id)){
            System.out.println("Id is not exist.");
        }
        else {
            employeesRepository.deleteById(id);
        }
    }

    private Double convertUSDToEuro() throws IOException {  //maybe to do it in a new service

        RestTemplate restTemplate = new RestTemplate();
        String ansJson = restTemplate.getForObject("https://v6.exchangerate-api.com/v6/8aa00d65b6b7fa3308a5aeca/pair/USD/EUR", String.class);
//        System.out.println("ans json: " + ansJson);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(ansJson);
        String convertUSDToEuro = jsonNode.get("conversion_rate").asText();   //~0.9162   12/16/23
//        System.out.println("convertUSDToEuro " + convertUSDToEuro);
        return Double.parseDouble(convertUSDToEuro);
    }
}