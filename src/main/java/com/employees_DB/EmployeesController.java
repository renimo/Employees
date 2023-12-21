package com.employees_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private final EmployeeService employeeService;
    //to make context class

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping( "employeeFromId")
    //@GetMapping("/employees/{id}")
    public Employee getEmployeesFromId(@RequestParam String id){ //getEmployeeDetails(@PathVariable("id") int id)
        return employeeService.findEmployeeFromId(id);
    }

    @GetMapping( "allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping( "allEmployeesEmails")
    public List<String> getAllEmployeesEmails(){
        return employeeService.findAllEmployeesEmails();
    }

    @PostMapping("insertEmployees")
    public void insertEmployees(@RequestBody List<Employee> employeeList) throws IOException {
        employeeService.insertEmployee(employeeList);
    }

    @PostMapping("insertEmployee")
    public void insertEmployee(@RequestBody Employee employee) throws IOException {
        employeeService.insertEmployee(List.of(employee));
    }

    @PutMapping("updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("deleteEmployee")      //example-> http://localhost:8080/employees/deleteEmployee?id=030303160
    public void deleteEmployee(@RequestParam String id){
        employeeService.deleteEmployee(id);
    }
}


//http://localhost:8080/employees/insertEmployees