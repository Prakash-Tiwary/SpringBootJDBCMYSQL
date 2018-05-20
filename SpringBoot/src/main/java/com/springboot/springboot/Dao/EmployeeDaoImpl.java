package com.springboot.springboot.Dao;

import com.springboot.springboot.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.sql.RowSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List<Employee> getAllEmployee() {
        String sql = "select * from employee";
        List<Employee> list= new ArrayList<>();
        List<Map<String,Object>> listOfEmp =  jdbcTemplate.queryForList(sql);
        for (Map<String,Object>row: listOfEmp
             ) {
            Employee employee = new Employee();
                 int empid = (Integer) row.get("employeeid");
                 String employeeFN = (String) row.get("employeefirstname");
                 String employeeLN = (String) row.get("employeelastname");
            employee.setEmployeefirstname(employeeFN);
            employee.setEmployeeid(empid);
            employee.setEmployeelastname(employeeLN);
                 list.add(employee);

        }
        //PreparedStatement statement= null;
        //List<Employee> list = new ArrayList<>();
        /*try {
            statement = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs= statement.executeQuery();

            while (rs.next()){
                Employee emp = new Employee();
                int employeeId = rs.getInt("employeeid");
                String employeefirstname= rs.getString("employeefirstname");
                String employeelastname = rs.getString("employeelastname");
                emp.setEmployeefirstname(employeefirstname);
                emp.setEmployeeid(employeeId);
                emp.setEmployeelastname(employeelastname);
                list.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return list;
        }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql = "Select * from  employee where employeeid= ?";
        return (Employee) jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs,int rwNum) throws SQLException{
                Employee e = new Employee();
                e.setEmployeeid(rs.getInt("employeeid"));
                e.setEmployeefirstname(rs.getString("employeefirstname"));
                e.setEmployeelastname(rs.getString("employeelastname"));
                return e;
            }
        });
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "Insert into employee " + "(employeefirstname,employeelastname) VALUES (?,?)";
        /*jdbcTemplate.update(sql,
                employee.getEmployeefirstname(),employee.getEmployeelastname());*/
        jdbcTemplate.update(sql,new Object[]{employee.getEmployeefirstname(),employee.getEmployeelastname()});

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(Employee employee) {

    }
}
