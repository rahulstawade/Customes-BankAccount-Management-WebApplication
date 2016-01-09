package com.techlabs.testcases.model;

import org.junit.Test;

import com.techlabs.domain.model.Account;
import com.techlabs.domain.model.Customer;
import com.techlabs.exceptions.BankingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class AccountTest {

	@Test
	public void shouldWithdrawAmountOnSufficientBalance() {
		Customer customer = new Customer(null, null, null, null,
				"currentpassword", null, null, null);
		Account accountToDebit = new Account(null, customer);
		accountToDebit.depositeAmount(3000);
		double oldBalance = accountToDebit.getAccountBalance();
		try {
			accountToDebit.isSufficientBalance(1500);
		} catch (BankingException ex) {
		}
		assertNotSame(oldBalance, accountToDebit.getAccountBalance());
	}

	@Test
	public void shouldNotWithdrawAmountOnInsufficientBalance() {
		Customer customer = new Customer(null, null, null, null,
				"currentpassword", null, null, null);
		Account accountToDebit = new Account(null, customer);
		double oldBalance = accountToDebit.getAccountBalance();
		try {
			accountToDebit.isSufficientBalance(1500);
		} catch (BankingException ex) {
		}
		assertEquals(oldBalance, accountToDebit.getAccountBalance(), 0);
	}

}
