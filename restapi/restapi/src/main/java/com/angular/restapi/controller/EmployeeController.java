package com.angular.restapi.controller;

import com.angular.restapi.model.Employee;
import com.angular.restapi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepo repo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return repo.findById(id).orElseThrow(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        repo.save(employee);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        Employee e = repo.findById(id).orElse(null);
        e.setName(employee.getName());
        e.setSalary(employee.getSalary());
        repo.save(e);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee e = repo.findById(id).orElse(null);
        repo.delete(e);
    }
}
