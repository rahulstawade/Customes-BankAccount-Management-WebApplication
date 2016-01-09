package com.techlabs.domain.model;

import com.techlabs.emums.UserType;

public class UserSessionData {
	private long sessionUserId;
	private UserType sessionUserType;

	public UserSessionData(long sessionUserId, UserType userType) {
		this.sessionUserId = sessionUserId;
		this.sessionUserType = userType;
	}

	public long getSessionUserId() {
		return sessionUserId;
	}

	public UserType getSessionUserType() {
		return sessionUserType;
	}

}