package com.pad.mysql.demo.dao;

import com.pad.mysql.demo.data.EmployeeHealthInsurance;

public interface HealthInsuranceDao {
    void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);

	void deleteEmployeeHealthInsuranceById(String empid);

}