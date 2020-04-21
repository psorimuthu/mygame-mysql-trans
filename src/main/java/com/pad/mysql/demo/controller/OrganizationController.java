package com.pad.mysql.demo.controller;

import com.pad.mysql.demo.data.Employee;
import com.pad.mysql.demo.data.EmployeeHealthInsurance;
import com.pad.mysql.demo.service.EmployeeService;
import com.pad.mysql.demo.service.OrganizationService;
import com.pad.mysql.demo.util.InvalidInsuranceAmountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @Autowired
    EmployeeService empService;

    @GetMapping(value="/org")
    public void updateOrganization() throws InvalidInsuranceAmountException{
        Employee emp = new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(2000);

		organizationService.joinOrganization(emp, employeeHealthInsurance);
        
    }

    @GetMapping(value="/emp")
    public void updateEmp(){
        Employee emp = new Employee();
		emp.setEmpId("emp2");
        emp.setEmpName("emp2");
        
        empService.insertEmployee(emp);

    }

}