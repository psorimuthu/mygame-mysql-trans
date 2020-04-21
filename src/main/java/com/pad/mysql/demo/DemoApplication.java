package com.pad.mysql.demo;

//import com.pad.mysql.demo.data.Employee;
// import com.pad.mysql.demo.data.EmployeeHealthInsurance;
// import com.pad.mysql.demo.service.OrganizationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		
		// ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// OrganizationService organizationService = context.getBean(OrganizationService.class);
		// Employee emp = new Employee();
		// emp.setEmpId("emp1");
		// emp.setEmpName("emp1");

		// EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		// employeeHealthInsurance.setEmpId("emp1");
		// employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		// employeeHealthInsurance.setCoverageAmount(20000);

		// organizationService.joinOrganization(emp, employeeHealthInsurance);

		
		
	}

}
