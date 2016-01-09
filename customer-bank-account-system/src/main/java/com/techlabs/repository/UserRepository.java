package com.techlabs.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.domain.model.Customer;
import com.techlabs.domain.model.User;

@Repository
public class UserRepository {
	@Autowired
	SessionFactory mySessionFactory;

	@SuppressWarnings("rawtypes")
	public User getUser(Class userClass, long userID) {

		Session session = mySessionFactory.getCurrentSession();
		User fetchedUser = (User) session.get(userClass, userID);
		
		return fetchedUser;
	}

	public void saveCustomer(Customer customerToSave) {
		Session session = mySessionFactory.getCurrentSession();
		session.save(customerToSave);
	}
}
