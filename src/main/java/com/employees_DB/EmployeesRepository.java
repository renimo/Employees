package com.employees_DB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends MongoRepository<Employee,String> {  //<Employee,ID> //An interface can extend other interfaces,

    @Query(value="{firstName:'?0'}", fields="{'country' : 1, 'city' : 1}")  //also mail?
    List<Employee> findAll(String category);  //the name //findAllByName

    @Query(value="{id:'?0'}")
    Employee findFromId(String id);

}
