package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.domain.model.Customer;
import com.techlabs.domain.model.Employee;
import com.techlabs.domain.model.User;
import com.techlabs.emums.UserType;
import com.techlabs.exceptions.BankingException;
import com.techlabs.repository.AccountRepository;
import com.techlabs.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AccountRepository accountRepository;

	@SuppressWarnings("rawtypes")
	@Transactional
	public void authenticateUser(long userId, String passwordSubmitted,
			Class usertype) {
		User currentUser = userRepository.getUser(usertype, userId);
		if (currentUser != null) {
			currentUser.authenticate(passwordSubmitted);
		} else {
			throw new BankingException(" Incorrect UserId/Password Details");
		}
	}

	@Transactional
	public void changePassword(long userId, String currentPassword,
			String newPassword, UserType userType) {

		if (userType.equals(UserType.CUSTOMER)) {
			Customer fetchedCustomer = (Customer) userRepository.getUser(
					Customer.class, userId);

			if (fetchedCustomer != null) {
				fetchedCustomer.changePassword(currentPassword, newPassword);

			} else {
				throw new BankingException(" Incorrect UserId/Password Details");
			}

		} else if (userType.equals(UserType.EMPLOYEE)) {
			Employee fetchedEmployee = (Employee) userRepository.getUser(
					Employee.class, userId);
			if (fetchedEmployee != null) {
				fetchedEmployee.changePassword(currentPassword, newPassword);
			} else {
				throw new BankingException(" Incorrect UserId/Password Details");
			}
		} else {
			throw new BankingException("Incorrect UserType");
		}
	}
}
