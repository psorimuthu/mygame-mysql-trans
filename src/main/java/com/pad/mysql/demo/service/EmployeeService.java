package com.pad.mysql.demo.service;

import com.pad.mysql.demo.data.Employee;

public interface EmployeeService {

    void insertEmployee(Employee emp);
    void deleteEmployee(String empId);

}