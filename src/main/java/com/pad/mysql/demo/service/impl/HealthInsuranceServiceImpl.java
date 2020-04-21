package com.pad.mysql.demo.service.impl;

import com.pad.mysql.demo.dao.HealthInsuranceDao;
import com.pad.mysql.demo.data.EmployeeHealthInsurance;
import com.pad.mysql.demo.service.HealthInsuranceService;
import com.pad.mysql.demo.util.InvalidInsuranceAmountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

    @Autowired
    HealthInsuranceDao healthInsuranceDao;

    @Override
    public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException{
        if(employeeHealthInsurance.getCoverageAmount()<=0){
            throw new InvalidInsuranceAmountException("Coverage amount should be positive");
        }
        healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);

    }

    @Override
    public void deleteEmployeeHealthInsuranceById(String empid) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empid);

    }

}