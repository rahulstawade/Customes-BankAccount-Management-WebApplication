package com.techlabs.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payee {

	@Id
	@Column(name = "Account_number")
	long payeeAccountNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	Customer payeerCustomer;

	public Payee() {
		// default constructor
	}

	public Payee(long payeeAccNo, Customer payeerCustomer) {
		payeeAccountNumber = payeeAccNo;
		this.payeerCustomer = payeerCustomer;
	}

	public long getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
}
