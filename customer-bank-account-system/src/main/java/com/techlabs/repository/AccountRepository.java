package com.techlabs.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.domain.model.Account;

@Repository
public class AccountRepository {
	@Autowired
	SessionFactory mySessionFactory;

	public Account getAccount(long accountId) {
		Session session = mySessionFactory.getCurrentSession();
		Account fetchedAccount = (Account) session
				.get(Account.class, accountId);
		return fetchedAccount;
	}
}
