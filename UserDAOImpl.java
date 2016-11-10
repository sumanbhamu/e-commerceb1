package com.suman.shopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suman.shopping.model.User;

@Repository(value="userDAO")

public class UserDAOImpl implements UserDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;


	public boolean isValidate(String name, String pass) {
		
			if (name.equals("sa") && pass.equals("sa")) {
				return true;
			} else {
				return false;
			}
		}
	
	

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory =sessionFactory;
		}


	@Transactional
	
	public boolean saveOrUpdate(User user) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(user);
			t.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
