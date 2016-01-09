package com.techlabs.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.techlabs.emums.AccountOperation;
import com.techlabs.emums.AccountType;
import com.techlabs.exceptions.BankingException;

@Entity
public class Account {
	// INSTANCE VARIABLES
	@Id
	@GeneratedValue
	@Column(name = "Account_Id")
	long accountId;

	@Column(name = "Account_Balance")
	double accountBalance;

	@Column(name = "Account_Type")
	@Enumerated(EnumType.STRING)
	AccountType accountType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	Customer customer;

	private static final int mininumBalance = 1000;

	// CONSTANT
	private static final double opningBalabce = 1000;

	// CONSTRUCTORS
	public Account() {
		// Default constructor
	}

	public Account(AccountType accountType, Customer customer) {

		this.accountBalance = opningBalabce;
		this.accountType = accountType;
		this.customer = customer;

	}

	// GETTERS AND SETTERS

	public long getAccountId() {
		return accountId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	// METHODS

	public void isSufficientBalance(double amountToWithdraw) {
		if ((accountBalance - amountToWithdraw) >= mininumBalance) {
			/* withdrawAmount(amountToWithdraw); */

		} else {
			throw new BankingException("Insufficient Balance To Withdraw Rs."
					+ amountToWithdraw);
		}

	}

	public void withdrawAmount(double amountToWithdraw) {
		accountBalance = accountBalance - amountToWithdraw;
	}

	public void depositeAmount(double amountToDeposite) {
		accountBalance = accountBalance + amountToDeposite;
	}

	public void accountOperation(AccountOperation operation, double amount) {
		if (operation.equals(AccountOperation.DEPOSITE)) {
			depositeAmount(amount);
		} else if (operation.equals(AccountOperation.WITHDRAW)) {
			isSufficientBalance(amount);
			withdrawAmount(amount);
		} else {
			throw new BankingException("Incorrect Opration Selected");
		}
	}
}
