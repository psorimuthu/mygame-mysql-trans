package com.pad.mysql.demo.dao;

import com.pad.mysql.demo.data.Employee;

public interface EmployeeDAO {
    void insertEmployee(Employee cus);
	void deleteEmployeeById(String empid);
}