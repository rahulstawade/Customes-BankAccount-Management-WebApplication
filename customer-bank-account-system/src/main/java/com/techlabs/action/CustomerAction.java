package com.techlabs.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.domain.model.Account;
import com.techlabs.domain.model.Customer;
import com.techlabs.domain.model.Payee;
import com.techlabs.emums.UserType;
import com.techlabs.exceptions.BankingException;
import com.techlabs.input.form.UserInputForm;
import com.techlabs.interceptor.IUserAware;
import com.techlabs.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements IUserAware {

	UserInputForm userForm = new UserInputForm();

	@Autowired
	CustomerService customerService;

	List<Account> listOfAccounts = new ArrayList<Account>();
	List<Payee> listOfPayee = new ArrayList<Payee>();
	List<Long> listOfAccountIds = new ArrayList<Long>();
	List<Long> listOfPayeeAccountIds = new ArrayList<Long>();
	long accountId;
	long payeeId;
	long userId;
	UserType userType;

	// Getters Setters

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

	public List<Long> getListOfPayeeAccountIds() {
		return listOfPayeeAccountIds;
	}

	public void setListOfPayeeAccountIds(List<Long> listOfPayeeAccountIds) {
		this.listOfPayeeAccountIds = listOfPayeeAccountIds;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(long payeeId) {
		this.payeeId = payeeId;
	}

	public List<Account> getListOfAccounts() {
		return listOfAccounts;
	}

	public void setListOfAccounts(List<Account> listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	// Methods
	public String transferMoney() {

		try {
			customerService.transferMoney(accountId, payeeId, userForm
					.getAccount().getAmount(), userId, userForm
					.getUserPassword());
		} catch (BankingException exception) {
			addActionError("TRANSACTION FAILED :- " + exception.getMessage());
			return "unsuccessfull";
		}
		addActionMessage("Rs." + userForm.getAccount().getAmount()
				+ " Successfully Transferred From Account ID [" + accountId
				+ "] To Payee Account [" + payeeId + "]");
		return "moneyTransferred";
	}

	public String prepareAccandPayeeList() {

		String result1 = getAccounts();
		String result2 = getPayees();

		if (result1.equalsIgnoreCase("accountsFetched")
				&& result2.equalsIgnoreCase("payeesFetched")) {

			return "listLodded";
		}
		return "unsuccessfull";
	}

	public String getPayees() {

		listOfPayee = customerService.getPayees(userId);
		for (Payee currentPayee : listOfPayee) {
			listOfPayeeAccountIds.add(currentPayee.getPayeeAccountNumber());
		}
		return "payeesFetched";
	}

	public String getAccounts() {
		try {
			listOfAccounts = customerService.getAccounts(userId);
		} catch (BankingException exception) {
			addActionError(exception.getMessage());
			return "unsuccessfull";
		}
		for (Account currentAccount : listOfAccounts) {
			listOfAccountIds.add(currentAccount.getAccountId());
		}
		return "accountsFetched";
	}

	public String fetchValues() {
		Customer fetchedCustomer = customerService.provideCustomer(userId);

		userForm.setUserId(fetchedCustomer.getUserId());
		userForm.setUserName(fetchedCustomer.getUserName());
		userForm.setUserGender(fetchedCustomer.getUserGender());
		userForm.setUserMaritialStatus(fetchedCustomer.getUserMaritialStatus());
		userForm.getUserContact().setUserEmailId(
				fetchedCustomer.getUserContact().getUserEmailId());
		userForm.getUserContact().setUserMobileNumber(
				fetchedCustomer.getUserContact().getUserMobile());
		userForm.getUserContact().setUserCity(
				fetchedCustomer.getUserContact().getUserCity());
		userForm.getUserContact().setUserPin(
				fetchedCustomer.getUserContact().getUserPin());
		userForm.getUserContact().setUserAddress(
				fetchedCustomer.getUserContact().getUserAddress());
		return "valuesInitialized";

	}

	public String updateCustomerProfile() {
		try {
			customerService.updateCustomer(userId, userForm.getUserContact()
					.getUserEmailId(), userForm.getUserContact()
					.getUserMobileNumber(), userForm.getUserContact()
					.getUserCity(), userForm.getUserContact().getUserPin(),
					userForm.getUserContact().getUserAddress());
		} catch (BankingException exception) {
			addActionError("Update Failed :- " + exception.getMessage());
			return "unsuccessfull";
		}
		addActionMessage("Customer Profile Updated Successfully");
		return "updated";
	}

	public String addPayee() {
		try {
			customerService.addPayee(userForm.getPayee()
					.getPayeeAccountNumber(), userId, userForm
					.getUserPassword());
		} catch (BankingException exception) {
			addActionError("Registration of New Payee Failed :- "
					+ exception.getMessage());
			return "unsuccessfull";
		}
		addActionMessage("Payee with Account Number ["
				+ userForm.getPayee().getPayeeAccountNumber()
				+ "] Added Successfully");
		return "payeeAdded";
	}

	@Override
	public void setUserSessionInfo(long userId, UserType userType) {
		this.userId = userId;
		this.userType = userType;

	}

}
