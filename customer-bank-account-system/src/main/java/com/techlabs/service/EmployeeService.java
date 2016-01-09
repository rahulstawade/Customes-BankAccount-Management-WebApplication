package com.techlabs.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.domain.model.Employee;
import com.techlabs.exceptions.BankingException;
import com.techlabs.repository.AccountRepository;
import com.techlabs.repository.UserRepository;

@Service
public class EmployeeService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AccountRepository accountRepository;	

	// Methods
	@Transactional
	public Employee provideEmployee(long employeeId) {
		Employee fetchedEmployee = (Employee) userRepository.getUser(
				Employee.class, employeeId);
		if (fetchedEmployee != null) {
			Hibernate.initialize(fetchedEmployee);
		} else {
			throw new BankingException("Invalid Employee ID");
		}
		return fetchedEmployee;
	}

	@Transactional
	public void updateEmployee(long employeeId, String newEmailId,
			long newMobileNo, String newCity, long newPin, String newAddress) {
		Employee employeeToUpdate = (Employee) userRepository.getUser(
				Employee.class, employeeId);
		if (employeeToUpdate != null) {
			employeeToUpdate.updateProfile(newEmailId, newMobileNo, newCity,
					newPin, newAddress);
		} else {
			throw new BankingException("Incorrect Employee Id");
		}
	}

}
