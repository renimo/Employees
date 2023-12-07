package com.employees_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.StandardOpenOption;
//import java.nio.file.Files;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

//                @GetMapping( "allEmployees")
//                public List<Employee> getAllEmployees(){
//                    return employeeService.getAllEmployees();
//                }
//
//                @GetMapping( "allEmployeesEmails")
//                public List<String> getAllEmployeesEmails(){
//                    return employeeService.getAllEmployeesEmails();
//                }


//    @GetMapping( "employeeFromId")
//    public Employee getEmployeesFromId(@RequestParam Integer id){
//        return employeeService.getEmployeeFromId(id);
//    }


    @PostMapping("insertEmployees")
    public void insertEmployees(@RequestBody List<Employee> employeeList) {//throws IOException {
        employeeService.insertEmployee(employeeList);
//        System.out.println(getAllEmployeesEmails());



//        System.out.println(employeeList.get(0));
//            List<String> lines = Arrays.asList("The third line", "The second line");
//            Path file = Paths.get("src/Employees.csv");
//            Files.write(file.toAbsolutePath(), employeeList, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

//    @PutMapping("updateEmployee")
//    public void updateEmployee(@RequestBody Employee employee){
//        employeeService.updateEmployee(employee);
//    }

    //update employees?

    //return the employee or void?
//
//    @DeleteMapping("deleteEmployee")
//    public void deleteEmployee(@RequestParam String id){
//        employeeService.deleteEmployee(id);
//    }
}
