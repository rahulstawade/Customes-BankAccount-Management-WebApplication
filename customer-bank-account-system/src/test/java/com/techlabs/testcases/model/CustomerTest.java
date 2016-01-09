package com.techlabs.testcases.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import junit.framework.Assert;

import org.junit.Test;

import com.techlabs.domain.model.Account;
import com.techlabs.domain.model.Customer;
import com.techlabs.emums.AccountStatus;
import com.techlabs.exceptions.BankingException;

public class CustomerTest {

	@Test
	public void shouldNotRegisterPayeeOnException() {
		Customer customer = new Customer(null, null, null, null, "password",
				AccountStatus.ACTIVE, null, null);
		Account payeeAccount = new Account(null, null);
		boolean exceptionFlag = false;
		try {
			customer.addPayee(payeeAccount, "incorrectPassword");
		} catch (BankingException e) {
			exceptionFlag = true;
		}
		if (!exceptionFlag) {
			Assert.fail("Exception aspected");
		}
	}

	@Test
	public void shouldRegisterPayeeOnNoBankingException() {
		Customer customer = new Customer(null, null, null, null, "password",
				AccountStatus.ACTIVE, null, null);
		Account payeeAccount = new Account(null, null);
		try {
			customer.addPayee(payeeAccount, "password");
		} catch (BankingException e) {
			Assert.fail("Exception not expected");
		}
	}

	@Test
	public void shouldTransferMoneyOnNoBankingException() {

		Customer customer = new Customer(null, null, null, null,
				"customerpassword", null, null, null);
		Customer payee = new Customer(null, null, null, null, "payeePassword",
				null, null, null);
		Account accountToDebit = new Account(null, customer);
		Account accountToCredit = new Account(null, payee);
		accountToDebit.depositeAmount(3000);
		double customerOldBalance = accountToDebit.getAccountBalance();
		try {
			customer.transferMoney("customerpassword", 1200, accountToDebit,
					accountToCredit);
		} catch (BankingException e) {
			Assert.fail("Exception not Expected");
		}
		assertNotSame(accountToDebit.getAccountBalance(), customerOldBalance);

	}

	@Test
	public void shouldNotTransferMoneyOnAndThrowExceptionIfIncorrectPassword() {

		Customer customer = new Customer(null, null, null, null,
				"customerpassword", null, null, null);
		Customer payee = new Customer(null, null, null, null, "payeePassword",
				null, null, null);
		Account accountToDebit = new Account(null, customer);
		Account accountToCredit = new Account(null, payee);
		accountToDebit.depositeAmount(3000);
		// double customerOldBalance = accountToDebit.getAccountBalance();
		boolean exceptionFlag = false;
		try {
			customer.transferMoney("incorrectpassword", 1200, accountToDebit,
					accountToCredit);
		} catch (BankingException e) {
			exceptionFlag = true;
		}
		if (!exceptionFlag) {
			Assert.fail("Exception aspected");
		}

	}

	@Test
	public void shouldNotTransferMoneyOnInsufficientBalance() {

		Customer customer = new Customer(null, null, null, null,
				"customerpassword", null, null, null);
		Customer payee = new Customer(null, null, null, null, "payeePassword",
				null, null, null);
		Account accountToDebit = new Account(null, customer);
		Account accountToCredit = new Account(null, payee);
		accountToDebit.depositeAmount(3000);
		double customerOldBalance = accountToDebit.getAccountBalance();
		try {
			customer.transferMoney("customerpassword", 5000, accountToDebit,
					accountToCredit);
		} catch (BankingException e) {
		}
		assertEquals(customerOldBalance, accountToDebit.getAccountBalance(), 0);
	}

}
