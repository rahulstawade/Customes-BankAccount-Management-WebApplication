package com.techlabs.action;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.domain.model.Account;
import com.techlabs.domain.model.Customer;
import com.techlabs.domain.model.Employee;
import com.techlabs.emums.AccountStatus;
import com.techlabs.emums.UserType;
import com.techlabs.exceptions.BankingException;
import com.techlabs.input.form.UserInputForm;
import com.techlabs.interceptor.IUserAware;
import com.techlabs.service.CustomerService;
import com.techlabs.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport implements IUserAware {

	UserInputForm userForm = new UserInputForm();
	@Autowired
	EmployeeService employeeService;
	@Autowired
	CustomerService customerService;

	HttpServletRequest request = ServletActionContext.getRequest();
	List<Account> listOfAccounts = new ArrayList<Account>();
	List<Long> listOfAccountIds = new ArrayList<Long>();

	double balance;
	long hiddenField;
	long userId;
	UserType userType;
	String welcomeEmpName;
	String welcomeEmpDepartment;
	long welcomeEmpContact;

	// GETTERS AND SETTERS

	public long getHiddenField() {
		return hiddenField;
	}

	public String getWelcomeEmpName() {
		return welcomeEmpName;
	}

	public void setWelcomeEmpName(String welcomeEmpName) {
		this.welcomeEmpName = welcomeEmpName;
	}

	public String getWelcomeEmpDepartment() {
		return welcomeEmpDepartment;
	}

	public void setWelcomeEmpDepartment(String welcomeEmpDepartment) {
		this.welcomeEmpDepartment = welcomeEmpDepartment;
	}

	public long getWelcomeEmpContact() {
		return welcomeEmpContact;
	}

	public void setWelcomeEmpContact(long welcomeEmpContact) {
		this.welcomeEmpContact = welcomeEmpContact;
	}

	public void setHiddenField(long hiddenField) {
		this.hiddenField = hiddenField;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public UserInputForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserInputForm userForm) {
		this.userForm = userForm;
	}

	public List<Long> getListOfAccountIds() {
		return listOfAccountIds;
	}

	public void setListOfAccountIds(List<Long> listOfAccountIds) {
		this.listOfAccountIds = listOfAccountIds;
	}

	// METHODS
	public String getEmployee() {
		Employee fetchedEmployee;
		try {
			fetchedEmployee = employeeService.provideEmployee(userId);
		} catch (BankingException exception) {
			addActionError(exception.getMessage());
			return "unsuccessfull";
		}
		welcomeEmpContact = fetchedEmployee.getUserContact().getUserMobile();
		welcomeEmpDepartment = fetchedEmployee.getEmployeeDepartment();
		welcomeEmpName = fetchedEmployee.getUserName();
		return "employeeDetailsFilled";
	}

	public String getCustomer() {

		Customer fetchedCustomer = new Customer();
		try {
			fetchedCustomer = customerService.provideCustomer(userForm
					.getUserId());
		} catch (BankingException exception) {
			addActionError("ERROR :- " + exception.getMessage());
			return "unsuccessfull";
		}

		userForm.setUserName(fetchedCustomer.getUserName());
		userForm.getUserContact().setUserEmailId(
				fetchedCustomer.getUserContact().getUserEmailId());
		userForm.getUserContact().setUserMobileNumber(
				fetchedCustomer.getUserContact().getUserMobile());
		hiddenField = userForm.getUserId();
		return "valuesSet";
	}

	public String changeCustomerStatus() {
		try {
			customerService.changeStatus(hiddenField,
					userForm.getUserAccountStatus(), getRandomePassword());
		} catch (BankingException exception) {
			addActionError("Status Not Changed :- " + exception.getMessage());
			return "unsuccessfull";
		}
		addActionMessage("Customer[" + hiddenField + "] Status changed to - "
				+ userForm.getUserAccountStatus());
		return "statusUpdated";
	}

	public String initilizeList() {
		listOfAccounts = new ArrayList<Account>();
		listOfAccountIds = new ArrayList<Long>();
		return "accListInitialized";
	}

	public String getCustomerAccounts() {
		try {
			listOfAccounts = customerService.getAccounts(userForm.getUserId());
		} catch (BankingException exception) {
			addActionError(exception.getMessage());
			return "unsuccessfull";
		}
		for (Account account : listOfAccounts) {
			listOfAccountIds.add(account.getAccountId());
		}
		return "accList";

	}

	public String getAccountBalance() {
		long accountIdSelected = Long.parseLong(request.getParameter("accid"));
		hiddenField = accountIdSelected;
		try {
			balance = customerService.getAccountBalance(hiddenField);
		} catch (BankingException exception) {
			addActionError(exception.getMessage());
			return "unsuccessfull";
		}
		return "balancereturned";
	}

	public String operationOnAccount() {
		try {
			customerService.operationsOnAccount(userForm.getAccount()
					.getAccountOperation(), userForm.getAccount().getAmount(),
					hiddenField);
		} catch (BankingException exception) {
			addActionError("Transaction Failed :- " + exception.getMessage());
			return "unsuccessfull";

		}
		addActionMessage("Transaction Successful");
		return "balanceUpdated";
	}

	public String fetchValues() {
		Employee fetchedEmployee = new Employee();
		try {
			fetchedEmployee = employeeService.provideEmployee(userId);
		} catch (BankingException exception) {
			addActionError(exception.getMessage());
			return "unsuccessfull";
		}

		userForm.setUserId(fetchedEmployee.getUserId());
		userForm.setUserName(fetchedEmployee.getUserName());
		userForm.setUserGender(fetchedEmployee.getUserGender());
		userForm.setUserMaritialStatus(fetchedEmployee.getUserMaritialStatus());
		userForm.getUserContact().setUserEmailId(
				fetchedEmployee.getUserContact().getUserEmailId());
		userForm.getUserContact().setUserMobileNumber(
				fetchedEmployee.getUserContact().getUserMobile());
		userForm.getUserContact().setUserCity(
				fetchedEmployee.getUserContact().getUserCity());
		userForm.getUserContact().setUserPin(
				fetchedEmployee.getUserContact().getUserPin());
		userForm.getUserContact().setUserAddress(
				fetchedEmployee.getUserContact().getUserAddress());
		return "valuesInitialized";

	}

	public String updateEmployeeProfile() {
		try {
			employeeService.updateEmployee(userId, userForm.getUserContact()
					.getUserEmailId(), userForm.getUserContact()
					.getUserMobileNumber(), userForm.getUserContact()
					.getUserCity(), userForm.getUserContact().getUserPin(),
					userForm.getUserContact().getUserAddress());
		} catch (BankingException exception) {
			addActionError("Update Failed :- " + exception.getMessage());
			return "unsuccessfull";
		}
		addActionMessage("Employee Information Updated");
		return "updated";
	}

	public String addNewCustomerAccount() {
		try {
			customerService.addNewCustomer(userForm.getUserName(), userForm
					.getUserDOB(), userForm.getUserGender(), userForm
					.getUserMaritialStatus(), getRandomePassword(),
					AccountStatus.INACTIVE, userForm.getUserContact()
							.getUserEmailId(), userForm.getUserContact()
							.getUserMobileNumber(), userForm.getUserContact()
							.getUserCity(), userForm.getUserContact()
							.getUserPin(), userForm.getUserContact()
							.getUserAddress(), userForm.getOccupation(),
					userForm.getAccount().getAccountType());
		} catch (BankingException exception) {
			addActionError("Failed To create new Customer :- "
					+ exception.getMessage());
			return "unsuccessfull";
		}
		addActionMessage("New Customer Added Successfully");
		return "customerAdded";
	}

	public String addNewAccount() {
		try {
			customerService.addNewAccount(userForm.getAccount()
					.getAccountType(), userForm.getUserId());
		} catch (BankingException exception) {
			addActionError("Failed To Create New Account :- "
					+ exception.getMessage());
			return "unsuccessfull";
		}
		addActionMessage("New Account Added Successfully");
		return "accountAdded";
	}

	public String getRandomePassword() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

	@Override
	public void setUserSessionInfo(long userId, UserType userType) {
		this.userId = userId;
		this.userType = userType;
	}

}
