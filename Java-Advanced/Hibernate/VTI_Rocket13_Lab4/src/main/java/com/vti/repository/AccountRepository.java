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

	public List<Account> getAllAccount() {
		Session session = null;

		try {
			session = hibernateUtils.openSession();

			Query<Account> query = session.createQuery("FROM Account order by id");

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountById(short id) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();

			Account account = session.get(Account.class, id);
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountByName(String name) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			Query<Account> query = session.createQuery("FROM Account WHERE username = :nameParameter");
			query.setParameter("nameParameter", name);
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountByEmail(String email) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			Query<Account> query = session.createQuery("FROM Account WHERE email = :emailParameter");
			query.setParameter("emailParameter", email);
			Account account = query.uniqueResult();
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account account) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount_Fullname(String newName, short id) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			Account account = session.load(Account.class, id);
			account.setFullname(newName);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount(Account account) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			session.update(account);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAccount(short id) {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			Account account = session.load(Account.class, id);
			session.delete(account);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsById(short id) {
		Account account = getAccountById(id);
		if (account != null) {
			return true;
		}
		return false;
	}

	public boolean isAccountExistsByName(String username) {
		Account account = getAccountByName(username);
		if (account != null) {
			return true;
		}
		return false;
	}

	public boolean isAccountExistsByEmail(String email) {
		Account account = getAccountByEmail(email);
		if (account != null) {
			return true;
		}
		return false;
	}

}
