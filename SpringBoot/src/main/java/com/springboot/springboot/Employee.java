package com.springboot.springboot;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeid;
    private String employeefirstname;
    private String employeelastname;


    public Employee() {
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeefirstname() {
        return employeefirstname;
    }

    public void setEmployeefirstname(String employeefirstname) {
        this.employeefirstname = employeefirstname;
    }

    public String getEmployeelastname() {
        return employeelastname;
    }

    public void setEmployeelastname(String employeelastname) {
        this.employeelastname = employeelastname;
    }
}
