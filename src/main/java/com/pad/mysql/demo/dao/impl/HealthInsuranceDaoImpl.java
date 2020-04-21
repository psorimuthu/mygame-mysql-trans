package com.pad.mysql.demo.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.pad.mysql.demo.dao.HealthInsuranceDao;
import com.pad.mysql.demo.data.EmployeeHealthInsurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class HealthInsuranceDaoImpl extends JdbcDaoSupport implements HealthInsuranceDao {

    @Autowired DataSource datasource;

    @PostConstruct
    public void initialize(){
        setDataSource(datasource);
    }

    @Override
    public void registerEmployeeHealthInsurance(EmployeeHealthInsurance empHI) {
        String sql = "INSERT INTO employeeHealthInsurance "
                + "(empId, healthInsuranceSchemeName, coverageAmount) VALUES (?, ?,?)";
        getJdbcTemplate().update(sql,new Object[]{empHI.getEmpId(), empHI.getHealthInsuranceSchemeName(), empHI.getCoverageAmount()});

    }

    @Override
    public void deleteEmployeeHealthInsuranceById(String empid) {
        String sql = "DELETE FROM employeeHealthInsurance WHERE empId = ?";
		getJdbcTemplate().update(sql, new Object[] { empid });

    }

    
}