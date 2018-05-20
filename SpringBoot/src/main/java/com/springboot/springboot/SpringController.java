package com.springboot.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpringController {
    @Autowired
    SpringBootService springBootService;
    @GetMapping("employee")
    public List<Employee> getEmployee(){


        return springBootService.getEmployee();
    }
    @GetMapping("employee/{employeeid}")
    public Employee getEmployeeById(@PathVariable("employeeid") int id){
        return springBootService.getEmployeeById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/employee")
    public void addEmployee(@RequestBody Employee employee){
        springBootService.addEmployee(employee);
        //return ResponseEntity.status(HttpStatus.OK).body(emp);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee")
    public void updateEmployee(@RequestBody Employee employee){
        springBootService.updateEmployee(employee);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "employee")
    public void deleteEmployee(@RequestBody Employee employee){
        springBootService.deleteEmployee(employee);
    }

}
