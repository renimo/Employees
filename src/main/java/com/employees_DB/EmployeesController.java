package com.employees_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping( "employeeFromId")
    //@GetMapping("/employees/{id}")
    public Employee getEmployeesFromId(@RequestParam String id){ //getEmployeeDetails(@PathVariable("id") int id)
        return employeeService.getEmployeeFromId(id);
    }

    @GetMapping( "allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping( "allEmployeesEmails")
    public List<String> getAllEmployeesEmails(){
        return employeeService.getAllEmployeesEmails();
    }

    @PostMapping("insertEmployees")
    public void insertEmployees(@RequestBody List<Employee> employeeList) {
        employeeService.insertEmployee(employeeList);
    }

    @PostMapping("insertEmployee")
    public void insertEmployee(@RequestBody Employee employee) {//throws IOException {
        employeeService.insertEmployee(List.of(employee));
    }

    @PutMapping("updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("deleteEmployee")      //example-> http://localhost:8080/employees/deleteEmployee?id=030303149
    public void deleteEmployee(@RequestParam String id){
        employeeService.deleteEmployee(id);
    }
}
