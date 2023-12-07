package com.employees_DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("Employees")  //object that belong to MongoDB
public class Employee {

    @Id
    private String id;

    private String name;
//    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private Double salary;
    private String email;
}