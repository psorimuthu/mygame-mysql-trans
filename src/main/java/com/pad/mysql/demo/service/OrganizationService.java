package com.pad.mysql.demo.service;

import com.pad.mysql.demo.data.Employee;
import com.pad.mysql.demo.data.EmployeeHealthInsurance;
import com.pad.mysql.demo.util.InvalidInsuranceAmountException;

public interface OrganizationService {

    public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException;

	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);

}