package com.techlabs.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	@Column(name = "Contact_id")
	long contactId;

	@Column(name = "Email_id", nullable = false, length = 50)
	String userEmailId;

	@Column(name = "Mobile_Number")
	long userMobile;

	@Column(name = "City", nullable = false, length = 20)
	String userCity;

	@Column(name = "Pin", nullable = false)
	long userPin;

	@Column(name = "Address", nullable = false)
	String userAddress;

	public Contact() {

	}

	public Contact(String userEmailId, long userMobile, String userCity,
			long userPin, String userAddress) {

		this.userEmailId = userEmailId;
		this.userMobile = userMobile;
		this.userCity = userCity;
		this.userPin = userPin;
		this.userAddress = userAddress;
	}

	public long getContactId() {
		return contactId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public long getUserMobile() {
		return userMobile;
	}

	public String getUserCity() {
		return userCity;
	}

	public long getUserPin() {
		return userPin;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void updateEmailId(String newEmailId) {
		userEmailId = newEmailId;
	}

	public void updateMobieNo(long newMobileNo) {
		userMobile = newMobileNo;
	}

	public void updateCity(String newCity) {
		userCity = newCity;
	}

	public void updatePin(long newPin) {
		userPin = newPin;
	}

	public void updateAddress(String newAddress) {
		userAddress = newAddress;
	}

	
}
