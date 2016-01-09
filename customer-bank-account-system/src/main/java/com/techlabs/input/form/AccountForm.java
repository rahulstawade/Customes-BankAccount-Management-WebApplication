package com.techlabs.input.form;

import com.techlabs.emums.AccountOperation;
import com.techlabs.emums.AccountType;

public class AccountForm {
	long accountId;
	float amount;
	AccountType accountType;
	AccountOperation accountOperation;
	
	
	public AccountOperation getAccountOperation() {
		return accountOperation;
	}
	public void setAccountOperation(AccountOperation accountOperation) {
		this.accountOperation = accountOperation;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
