package com.employees_DB;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeesRepository employeesRepository;

    public List<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public List<String> getAllEmployeesEmails(){
        List<Employee> allEmployees = getAllEmployees();  //can i get here just the emails from DB?
        List<String> allEmployeesEmails = new ArrayList<>();

        for (Employee emp: allEmployees) {  //stream
            allEmployeesEmails.add(emp.getEmail());
        }
        System.out.println(allEmployeesEmails);
        return allEmployeesEmails;
    }

    public Employee getEmployeeFromId(String id){
        return employeesRepository.findFromId(id);
    }

    public void insertEmployee(List<Employee> employeeList) {//throws IOException {
        //to validate not exist before
//        for (Employee emp: employeeList) {
////            emp.setSalary(convertUSDToEuro(emp.getSalary()));
//        }

        employeesRepository.saveAll(employeeList);

        for (Employee employee: employeeList) {
            SendNotification.sendNotification(); //to send list of new employees
        }
    }

    // If entities are already available in collection in MongoDB, then they will be updated.
    // otherwise they will be inserted as new entities
    public void updateEmployee(Employee employee){
        employeesRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeesRepository.deleteById(id);
    }

//    public Double convertUSDToEuro(Double salaryOnUSD) throws IOException {
//
//        RestTemplate restTemplate = new RestTemplate();
//        String ansJson = restTemplate.getForObject("https://v6.exchangerate-api.com/v6/8aa00d65b6b7fa3308a5aeca/pair/USD/EUR", String.class);
//        //System.out.println(ansJson);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(ansJson);
//        String convertUSDToEuro = jsonNode.get("conversion_rate").asText();   //about 0.98 31/07/22
//        //System.out.println(convertUSDToEuro);
//        return salaryOnUSD * Double.parseDouble(convertUSDToEuro);      //from string to double
//
//    }

}