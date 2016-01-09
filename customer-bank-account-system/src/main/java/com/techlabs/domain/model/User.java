package com.techlabs.domain.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.techlabs.emums.AccountStatus;
import com.techlabs.emums.Gender;
import com.techlabs.emums.MaritialStatus;
import com.techlabs.exceptions.BankingException;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

	/* Logger logger = LoggerFactory.getLogger(User.class); */

	// Ivars
	@Id
	@Column(name = "User_Id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	long userId;

	@Column(name = "User_Name")
	String userName;

	@Column(name = "Date_Of_Birth")
	Date userDOB;

	@Column(name = "Gender")
	@Enumerated(EnumType.STRING)
	Gender userGender;

	@Column(name = "Maritial_Status")
	@Enumerated(EnumType.STRING)
	MaritialStatus userMaritialStatus;

	@Column(name = "User_Password")
	String password;

	@Column(name = "Account_status")
	@Enumerated(EnumType.STRING)
	AccountStatus userAccountStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Contact_id")
	Contact userContact;

	// constructor

	public User() {

	}

	public User(String name, Date dob, Gender gender,
			MaritialStatus maritialStatus, String password,
			AccountStatus accStatus, Contact contact_info) {

		userName = name;
		userDOB = dob;
		userGender = gender;
		userMaritialStatus = maritialStatus;
		this.password = password;
		userAccountStatus = accStatus;
		userContact = contact_info;
	}

	// getters

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public Gender getUserGender() {
		return userGender;
	}

	public MaritialStatus getUserMaritialStatus() {
		return userMaritialStatus;
	}

	public String getPassword() {
		return password;
	}

	public AccountStatus getUserAccountStatus() {
		return userAccountStatus;
	}

	public Contact getUserContact() {
		return userContact;
	}

	// Methods
	public void updatePassword(String newPassword) {
		this.password = newPassword;
	}

	public void updateAccountStatus(AccountStatus status) {
		userAccountStatus = status;
	}

	public void authenticate(String passwordSubmitted) {
		if (passwordSubmitted.equals(getPassword())) {
			if (getUserAccountStatus() != AccountStatus.ACTIVE) {
				updateAccountStatus(AccountStatus.ACTIVE);
			}
			/* logger.debug("Authenticated"); */
		} else {
			throw new BankingException("Incorrect Password Entered");
		}
	}

	public void changePassword(String currentPassword, String newPassword) {
		authenticate(currentPassword);
		updatePassword(newPassword);
	}

}
