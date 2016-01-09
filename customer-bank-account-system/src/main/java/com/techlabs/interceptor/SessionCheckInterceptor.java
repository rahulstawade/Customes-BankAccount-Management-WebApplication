package com.techlabs.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.techlabs.domain.model.UserSessionData;

@SuppressWarnings("serial")
public class SessionCheckInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> loginSession = invocation.getInvocationContext()
				.getSession();
		System.out.println("========== ============ INSIDE INTERCEPTOR =========== =============");
		UserSessionData sessionData = (UserSessionData) loginSession
				.get("UserSessionInfo");
		if (sessionData == null) {
			return "login";
		} else if (invocation.getAction() instanceof IUserAware) {
			((IUserAware) invocation.getAction()).setUserSessionInfo(
					sessionData.getSessionUserId(),
					sessionData.getSessionUserType());
			System.out.println("========= ============ INSIDE INTERCEPTOR : Session Values Set....!!! ");
		}
		return invocation.invoke();
	}
}
