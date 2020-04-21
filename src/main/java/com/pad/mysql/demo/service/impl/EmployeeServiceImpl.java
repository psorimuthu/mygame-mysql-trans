package com.pad.mysql.demo.service.impl;

import com.pad.mysql.demo.dao.EmployeeDAO;
import com.pad.mysql.demo.data.Employee;
import com.pad.mysql.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO empDAO;

    @Override
    public void insertEmployee(Employee emp) {
        empDAO.insertEmployee(emp);

    }

    @Override
    public void deleteEmployee(String empId) {
        empDAO.deleteEmployeeById(empId);
    }

}