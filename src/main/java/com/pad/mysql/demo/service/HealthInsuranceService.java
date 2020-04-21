package com.pad.mysql.demo.service;

import com.pad.mysql.demo.data.EmployeeHealthInsurance;
import com.pad.mysql.demo.util.InvalidInsuranceAmountException;

public interface HealthInsuranceService {

    void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException;

	void deleteEmployeeHealthInsuranceById(String empid);

}