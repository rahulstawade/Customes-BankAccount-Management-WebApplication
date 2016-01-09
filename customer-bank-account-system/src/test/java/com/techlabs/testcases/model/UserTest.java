package com.techlabs.testcases.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import junit.framework.Assert;

import org.junit.Test;

import com.techlabs.domain.model.Customer;
import com.techlabs.domain.model.User;
import com.techlabs.exceptions.BankingException;

public class UserTest {
	private User user;

	@Test
	public void shouldNotThrowAnExceptionIfCorrectUser() {
		user = new Customer(null, null, null, null, "userCorrectPassword",
				null, null, null);
		try {
			user.authenticate("userCorrectPassword");
		} catch (Exception e) {
			Assert.fail("Exception not expected");
		}

	}

	@Test
	public void shouldThrowAnExceptionIfIncorrectUser() {
		user = new Customer(null, null, null, null, "userCorrectPassword",
				null, null, null);
		boolean exceptionFlag = false;
		try {
			user.authenticate("incorrectPassword");
		} catch (BankingException e) {
			exceptionFlag = true;
		}
		if (!exceptionFlag) {
			Assert.fail("Exception expected");
		}

	}

	@Test
	public void shouldNotChangePasswordOnBankingException() {
		String newPassword = "newPassword";
		User user = new Customer(null, null, null, null, "oldpassword", null,
				null, null);
		try {
			user.changePassword("incorrectPassword", newPassword);
		} catch (BankingException e) {
			assertNotSame(user.getPassword(), newPassword);
		}
	}

	@Test
	public void shouldChangePasswordOnNoBankingException() {
		String newPassword = "newPassword";
		User user = new Customer(null, null, null, null, "oldPassword", null,
				null, null);
		try {
			user.changePassword("oldPassword", newPassword);
		} catch (BankingException e) {
			assertNotSame(user.getPassword(), newPassword);
		}
		assertEquals(user.getPassword(), newPassword);

	}

}
