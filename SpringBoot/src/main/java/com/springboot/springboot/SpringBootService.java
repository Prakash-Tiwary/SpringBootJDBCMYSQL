package com.springboot.springboot;

import com.springboot.springboot.Dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringBootService {
    @Autowired
    DataRepository dataRepository;
    @Autowired
    EmployeeDao employeeDao;



    public List<Employee> getEmployee(){
       //List<Employee> empList = dataRepository.findAll();
       //return empList;

        List<Employee> empList = employeeDao.getAllEmployee();
        return empList;

    }
    public Employee getEmployeeById(Integer id){
        //Employee emp = dataRepository.findById(id).get();
        Employee emp = employeeDao.getEmployeeById(id);
        return emp;

    }

    public void addEmployee(Employee employee){
         employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        dataRepository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        dataRepository.delete(employee);
    }
}
