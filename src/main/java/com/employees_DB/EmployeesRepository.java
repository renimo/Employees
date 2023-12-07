package com.employees_DB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeesRepository extends MongoRepository<Employee,String> {  //<Employee,ID>

    @Query(value="{name:'?0'}", fields="{'country' : 1, 'city' : 1}")  //also mail?
    List<Employee> findAll(String category);  //the name //findAllByName

    @Query(value="{id:'?0'}")
    Employee findFromId(Integer id);

}
