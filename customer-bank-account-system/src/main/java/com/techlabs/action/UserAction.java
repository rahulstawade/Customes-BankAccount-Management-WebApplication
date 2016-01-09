package com.techlabs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.domain.model.Customer;
import com.techlabs.domain.model.Employee;
import com.techlabs.domain.model.UserSessionData;
import com.techlabs.emums.UserType;
import com.techlabs.exceptions.BankingException;
import com.techlabs.input.form.UserInputForm;
import com.techlabs.interceptor.IUserAware;
import com.techlabs.service.UserService;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements IUserAware {
	UserInputForm userForm;

	@Autowired
	UserService userService;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession sessionObj = request.getSession();

	long userId;
	UserType userType;

	public UserInputForm getUserForm() {
		return userForm;

	}

	public void setUserForm(UserInputForm userForm) {
		this.userForm = userForm;
	}

	public String authenticateUser() {

		if (userForm.getUserType().equals(UserType.CUSTOMER)) {
			try {
				userService.authenticateUser(userForm.getUserId(),
						userForm.getUserPassword(), Customer.class);
			} catch (BankingException exception) {
				addActionError("LOGIN FAILED : " + exception.getMessage());
				return "unsuccessfull";
			}

			UserSessionData userSessionInfo = new UserSessionData(
					userForm.getUserId(), userForm.getUserType());
			sessionObj.setAttribute("UserSessionInfo", userSessionInfo);
			return "customer";
		} else if (userForm.getUserType().equals(UserType.EMPLOYEE)) {
			try {
				userService.authenticateUser(userForm.getUserId(),
						userForm.getUserPassword(), Employee.class);

			} catch (BankingException exception) {
				addActionError("LOGIN FAILED : " + exception.getMessage());
				return "unsuccessfull";
			}

			UserSessionData userSessionInfo = new UserSessionData(
					userForm.getUserId(), userForm.getUserType());

			sessionObj.setAttribute("UserSessionInfo", userSessionInfo);
		}
		return "employee";
	}

	public String logOutUser() {
		sessionObj.invalidate();
		addActionMessage("You Have Successfull Logged out !!! Enter Details To Login Again");
		return "loggedOut";
	}

	public String changePassword() {
		try {
			userService.changePassword(userId, userForm.getUserPassword(),
					userForm.getUsernewPassword(), userType);
		} catch (BankingException exception) {
			addActionError("Change Password Failed :- "
					+ exception.getMessage());
			return "unsuccessfull";
		}
		if (userType.equals(UserType.CUSTOMER)) {
			addActionMessage("Password Successfully changed ");
			return "customer";
		}
		addActionMessage("Password Successfully changed ");
		return "employee";

	}

	@Override
	public void setUserSessionInfo(long userId, UserType userType) {
		this.userId = userId;
		this.userType = userType;
	}

}
