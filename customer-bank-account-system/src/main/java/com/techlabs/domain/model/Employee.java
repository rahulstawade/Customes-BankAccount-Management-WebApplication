package com.techlabs.domain.model;

import java.util.Date;

import javax.persistence.Entity;

import com.techlabs.emums.AccountStatus;
import com.techlabs.emums.Gender;
import com.techlabs.emums.MaritialStatus;

@Entity
public class Employee extends User {
	/*
	 * @Column(name = "Qualification")
	 */String employeeQualification;

	/*
	 * @Column(name = "Department")
	 */String employeeDepartment;

	public Employee() {

	}

	public Employee(String name, Date dob, Gender gender,
			MaritialStatus maritialStatus, String password,
			AccountStatus accStatus, Contact contactInfo, String qualification,
			String department) {

		super(name, dob, gender, maritialStatus, password, accStatus,
				contactInfo);
		employeeQualification = qualification;
		employeeDepartment = department;
	}

	public String getEmployeeQualification() {
		return employeeQualification;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void updateProfile(String newEmailId, long newMobileNo,
			String newCity, long newPin, String newAddress) {
		getUserContact().updateEmailId(newEmailId);
		getUserContact().updateMobieNo(newMobileNo);
		getUserContact().updateCity(newCity);
		getUserContact().updatePin(newPin);
		getUserContact().updateAddress(newAddress);
	}

}
