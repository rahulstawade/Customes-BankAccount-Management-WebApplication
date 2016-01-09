package com.techlabs.interceptor;

import com.techlabs.emums.UserType;

public interface IUserAware {

	public void setUserSessionInfo(long userId,UserType userType);

}
