package com.techlabs.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.techlabs.emums.AccountStatus;
import com.techlabs.emums.AccountType;
import com.techlabs.emums.Gender;
import com.techlabs.emums.MaritialStatus;

@Entity
public class Customer extends User {

	@Column(name = "Occupation")
	String occupation;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	List<Account> accountList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "payeerCustomer")
	List<Payee> payeeList;

	public Customer() {

	}

	public Customer(String name, Date dob, Gender gender,
			MaritialStatus maritialStatus, String password,
			AccountStatus accStatus, Contact contactInfo, String occupation) {

		super(name, dob, gender, maritialStatus, password, accStatus,
				contactInfo);

		this.occupation = occupation;
		accountList = new ArrayList<Account>();
		payeeList = new ArrayList<Payee>();

	}

	public List<Payee> getPayeeList() {
		return payeeList;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public String getOccupation() {
		return occupation;
	}

	// METHODS

	public Customer createNewCustomer(String name, Date dob, Gender gender,
			MaritialStatus maritialStatus, String password,
			AccountStatus accStatus, String userEmailId, long userMobile,
			String userCity, long userPin, String userAddress,
			String occupation, AccountType accType) {

		Customer newlyCreatedCustomer = new Customer(name, dob, gender,
				maritialStatus, password, accStatus, new Contact(userEmailId,
						userMobile, userCity, userPin, userAddress), occupation);

		Account newCustomerAccount = new Account(accType, newlyCreatedCustomer);
		newlyCreatedCustomer.getAccountList().add(newCustomerAccount);

		return newlyCreatedCustomer;

	}

	public void transferMoney(String passwordSubmitted, double transferAmount,
			Account accountToDebit, Account payeeToCredit) {

		authenticate(passwordSubmitted);
		accountToDebit.isSufficientBalance(transferAmount);
		accountToDebit.withdrawAmount(transferAmount);
		payeeToCredit.depositeAmount(transferAmount);   /*depositeMoney(transferAmount);*/

	}

	public void updateProfile(String newEmailId, long newMobileNo,
			String newCity, long newPin, String newAddress) {
		getUserContact().updateEmailId(newEmailId);
		getUserContact().updateMobieNo(newMobileNo);
		getUserContact().updateCity(newCity);
		getUserContact().updatePin(newPin);
		getUserContact().updateAddress(newAddress);
	}

	public void addPayee(Account payeeAccount, String passwordSubmitted) {
		authenticate(passwordSubmitted);
		Payee payeeToAdd = new Payee(payeeAccount.accountId,/*
				payeeAccount.accountBalance,*/ this);
		getPayeeList().add(payeeToAdd);
	}

}
