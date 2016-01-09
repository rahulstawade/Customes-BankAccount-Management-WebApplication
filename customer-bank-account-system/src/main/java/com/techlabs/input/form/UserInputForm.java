package com.techlabs.input.form;

import java.util.Date;

import com.techlabs.emums.AccountStatus;
import com.techlabs.emums.Gender;
import com.techlabs.emums.MaritialStatus;
import com.techlabs.emums.UserType;

public class UserInputForm {
	// Ivars

	long userId;
	String userName;
	Date userDOB;
	Gender userGender;
	UserType userType;
	MaritialStatus userMaritialStatus;
	String userPassword;
	String usernewPassword;
	String userconfirmPassword;
	AccountStatus userAccountStatus;

	String occupation;

	String qualification;
	String department;

	AccountForm account = new AccountForm();

	ContactForm userContact = new ContactForm();
	PayeeForm payee = new PayeeForm();

	// getters and setters

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public AccountForm getAccount() {
		return account;
	}

	public void setAccount(AccountForm account) {
		this.account = account;
	}

	public ContactForm getUserContact() {
		return userContact;
	}

	public void setUserContact(ContactForm userContact) {
		this.userContact = userContact;
	}

	public PayeeForm getPayee() {
		return payee;
	}

	public void setPayee(PayeeForm payee) {
		this.payee = payee;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	public Gender getUserGender() {
		return userGender;
	}

	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}

	public MaritialStatus getUserMaritialStatus() {
		return userMaritialStatus;
	}

	public void setUserMaritialStatus(MaritialStatus userMaritialStatus) {
		this.userMaritialStatus = userMaritialStatus;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUsernewPassword() {
		return usernewPassword;
	}

	public void setUsernewPassword(String usernewPassword) {
		this.usernewPassword = usernewPassword;
	}

	public String getUserconfirmPassword() {
		return userconfirmPassword;
	}

	public void setUserconfirmPassword(String userconfirmPassword) {
		this.userconfirmPassword = userconfirmPassword;
	}

	public AccountStatus getUserAccountStatus() {
		return userAccountStatus;
	}

	public void setUserAccountStatus(AccountStatus userAccountStatus) {
		this.userAccountStatus = userAccountStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
