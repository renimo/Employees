package com.employees_DB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeesRepository extends MongoRepository<Employee, String> {

    @Query(value = "{id:'?0'}")
    Employee findFromId(String id); //private

    //how many employees

}
