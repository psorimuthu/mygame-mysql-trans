package com.pad.mysql.demo.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.pad.mysql.demo.dao.EmployeeDAO;
import com.pad.mysql.demo.data.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO {

    @Autowired
    DataSource datasource;

    @PostConstruct
    public void initialize(){
        setDataSource(datasource);
    }

    @Override
    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] { emp.getEmpId(), emp.getEmpName() });
	}

    

    @Override
    public void deleteEmployeeById(String empid) {
        String sql = "DELETE from employee where empId = ?";
        getJdbcTemplate().update(sql,new Object[] {empid});

    }

}