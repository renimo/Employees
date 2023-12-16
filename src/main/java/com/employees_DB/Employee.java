package com.employees_DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("Employees")
public class Employee {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private Double salary;
    private String email;
    private Role role;
}







//[
//        {
//        "id":"030303149",
//        "firstName":"Renana",
//        "lastName":"Moses",
//        "country":"Israel",
//        "city":"Modiin",
//        "salary":"3000",
//        "email":"Renana.moses@gmail.com",
//        "role": "REGULAR"
//        }
//        ]