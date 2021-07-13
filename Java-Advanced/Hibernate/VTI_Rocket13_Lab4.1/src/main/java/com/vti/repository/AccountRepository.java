package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.ultis.HibernateUtils;

public class AccountRepository {
	private HibernateUtils hibernateUtils;
	
	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public List<Account> get_FROM() {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "FROM Account ORDER BY id";
			Query<Account> query = session.createQuery(hql);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Account  getAccountById(short id) {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "FROM Account AS u WHERE u.id = :id";
			Query<Account> query = session.createQuery(hql, Account.class);
			query.setParameter("id", id);
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Account  getAccountByEmail(String email) {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "FROM Account AS u WHERE u.email = :email";
			Query<Account> query = session.createQuery(hql, Account.class);
			query.setParameter("email", email);
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public String  getAccountByFullName(short id) {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "SELECT a.fullname FROM Account a WHERE a.id = :id";
			Query<String> query = session.createQuery(hql, String.class);
			query.setParameter("id", id);
			String fullname = query.uniqueResult();
			return fullname;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Account> getAccountInCurrentMonth() {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "FROM Account a WHERE month(a.createDate) = month(sysdate())";
			Query<Account> query = session.createQuery(hql, Account.class);
			List<Account> list = query.list();
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Account> getAccountInCurrentMonthOrderBy() {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "FROM Account a WHERE month(a.createDate) = month(sysdate()) ORDER BY a.createDate DESC";
			Query<Account> query = session.createQuery(hql, Account.class);
			List<Account> list = query.list();
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Object[]> getCountAccountInCurrentMonthInYear() {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "SELECT month(createDate) AS month, COUNT(createDate) AS SL FROM Account WHERE year(createDate) = year(sysdate()) GROUP BY month(createDate)";
			Query<Object[]> query = session.createQuery(hql);
			List<Object[]> list = query.list();
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Object[]> getCountAccountInCurrentMonthInYearMoreThan2() {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			String hql = "SELECT month(createDate) AS month, COUNT(createDate) AS SL FROM Account WHERE year(createDate) = year(sysdate()) GROUP BY month(createDate) HAVING COUNT(createDate) > 2 ";
			Query<Object[]> query = session.createQuery(hql);
			List<Object[]> list = query.list();
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateEmailUsernammAccountById(String newEmail, String newUsername, short id) {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			String hql = "UPDATE Account SET email = :email, username = :username WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("email", newEmail);
			query.setParameter("username", newUsername);
			query.setParameter("id", id);
			int affectedRow = query.executeUpdate();
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteAccountByEmail(String email) {
		//deleteAccountByEmail(String username
		//deleteAccountByEmail(short id)
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			String hql = "DELETE Account WHERE email = :email";
//			String hql = "DELETE Account WHERE username = :username";
//			String hql = "DELETE Account WHERE  = :id";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
//			query.setParameter("username", username);
//			query.setParameter("id", id);
			int affectedRow = query.executeUpdate();
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Account> get_AccountPaging() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			String hql = "FROM Account ORDER BY id";
			Query<Account> query = session.createQuery(hql);
			query.setFirstResult(5);
			query.setMaxResults(3);
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
