package com.pad.mysql.demo.service.impl;


import com.pad.mysql.demo.data.Employee;
import com.pad.mysql.demo.data.EmployeeHealthInsurance;
import com.pad.mysql.demo.service.EmployeeService;
import com.pad.mysql.demo.service.HealthInsuranceService;
import com.pad.mysql.demo.service.OrganizationService;
import com.pad.mysql.demo.util.InvalidInsuranceAmountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganzationServiceImpl implements OrganizationService {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    HealthInsuranceService healthInsuranceService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance)
            throws InvalidInsuranceAmountException {
        employeeService.insertEmployee(employee);
        // if (employee.getEmpId().equals("emp1")) {
        // throw new TransExceptionTutorial();
        // }
        try {
            healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
        } catch (InvalidInsuranceAmountException e) {
            throw new InvalidInsuranceAmountException("Invalid insurance amt");
        }
	}

    @Override
    @Transactional
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployee(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}