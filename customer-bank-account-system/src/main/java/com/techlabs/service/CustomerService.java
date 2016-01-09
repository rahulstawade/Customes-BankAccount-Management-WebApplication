package com.techlabs.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.domain.model.Account;
import com.techlabs.domain.model.Customer;
import com.techlabs.domain.model.Payee;
import com.techlabs.emums.AccountOperation;
import com.techlabs.emums.AccountStatus;
import com.techlabs.emums.AccountType;
import com.techlabs.emums.Gender;
import com.techlabs.emums.MaritialStatus;
import com.techlabs.exceptions.BankingException;
import com.techlabs.repository.AccountRepository;
import com.techlabs.repository.UserRepository;

@Service
public class CustomerService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	AccountRepository accountRepository;
	
	//METHODS
	@Transactional
	public List<Account> getAccounts(long customerId) {
		Customer customer = (Customer) userRepository.getUser(Customer.class,
				customerId);
		List<Account> customerAccounts;
		if (customer != null) {
			customerAccounts = customer.getAccountList();
			Hibernate.initialize(customerAccounts);
		} else {
			throw new BankingException("Invalid Customer ID");
		}
		return customerAccounts;
	}

	@Transactional
	public List<Payee> getPayees(long customerId) {
		Customer customer = (Customer) userRepository.getUser(Customer.class,
				customerId);
		List<Payee> customerPayees = customer.getPayeeList();
		Hibernate.initialize(customerPayees);
		return customerPayees;
	}

	@Transactional
	public void addNewCustomer(String name, Date dob, Gender gender,
			MaritialStatus maritialStatus, String password,
			AccountStatus accStatus, String customerEmailId,
			long customerMobile, String customerCity, long customerPin,
			String customerAddress, String occupation, AccountType accType) {

		Customer customer = new Customer();
		Customer newlyCreatedCustomer = customer.createNewCustomer(name, dob,
				gender, maritialStatus, password, accStatus, customerEmailId,
				customerMobile, customerCity, customerPin, customerAddress,
				occupation, accType);

		userRepository.saveCustomer(newlyCreatedCustomer);

	}

	@Transactional
	public void addNewAccount(AccountType accountType, long customerId) {
		Customer customerFetched = (Customer) userRepository.getUser(
				Customer.class, customerId);
		Account newAccount = new Account(accountType, customerFetched);
		if (customerFetched != null) {
			customerFetched.getAccountList().add(newAccount);
		} else {
			throw new BankingException("Invalid Customer Id");
		}

	}

	@Transactional
	public void changeStatus(long customerId, AccountStatus newStatus,
			String newPassword) {
		Customer customerFetched = (Customer) userRepository.getUser(
				Customer.class, customerId);
		if (customerFetched != null) {
			customerFetched.updateAccountStatus(newStatus);
			customerFetched.updatePassword(newPassword);
		} else {
			throw new BankingException("Invalid Customer Id");
		}
	}

	@Transactional
	public void transferMoney(long customersAccountId, long payeeAccountNo,
			double transferAmount, long customerId, String passwordSubmitted) {
		Customer customer = (Customer) userRepository.getUser(Customer.class,
				customerId);
		Account accountToDebit = accountRepository
				.getAccount(customersAccountId);
		Account payeeToCredit = accountRepository.getAccount(payeeAccountNo);

		customer.transferMoney(passwordSubmitted, transferAmount,
				accountToDebit, payeeToCredit);
	}

	@Transactional
	public double getAccountBalance(long accountId) {
		Account account = accountRepository.getAccount(accountId);
		double accountBalance;
		if (account != null) {
			accountBalance = account.getAccountBalance();
		} else {
			throw new BankingException("Invalid Account Number");
		}
		return accountBalance;
	}

	@Transactional
	public void operationsOnAccount(AccountOperation operation, double amount,
			long accountId) {
		Account accountToOperate = accountRepository.getAccount(accountId);
		if (accountToOperate != null) {
			accountToOperate.accountOperation(operation, amount);
		} else {
			throw new BankingException("Account Id: " + accountId
					+ " is Not a Valid Acount ID");
		}
	}

	@Transactional
	public Customer provideCustomer(long customerId) {
		Customer fetchedCustomer = (Customer) userRepository.getUser(
				Customer.class, customerId);
		if (fetchedCustomer != null) {
			Hibernate.initialize(fetchedCustomer);
		} else {
			throw new BankingException("Incorrect Customer ID");
		}

		return fetchedCustomer;
	}

	@Transactional
	public void updateCustomer(long customerId, String newEmailId,
			long newMobileNo, String newCity, long newPin, String newAddress) {
		Customer customerToUpdate = (Customer) userRepository.getUser(
				Customer.class, customerId);
		if (customerToUpdate != null) {
			customerToUpdate.updateProfile(newEmailId, newMobileNo, newCity,
					newPin, newAddress);
		} else {
			throw new BankingException("Invalid Customer Id");
		}
	}

	@Transactional
	public void addPayee(long payeeAccNo, long customerId,
			String passwordSubmitted) {
		Customer customerToInsertPayee = (Customer) userRepository.getUser(
				Customer.class, customerId);
		Account payeeAccount = accountRepository.getAccount(payeeAccNo);
		if (customerToInsertPayee != null) {
			if (payeeAccount != null) {
				customerToInsertPayee.addPayee(payeeAccount, passwordSubmitted);
			} else {
				throw new BankingException("Invalid Payee Account Number");
			}
		} else {
			throw new BankingException("Invalid Customer Id");
		}
	}
}
