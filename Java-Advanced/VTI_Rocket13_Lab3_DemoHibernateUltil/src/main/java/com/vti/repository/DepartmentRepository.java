package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Department;
import com.vti.ultis.HibernateUtils;

public class DepartmentRepository {
	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Department> getAllDepartment() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Department> query = session.createQuery("FROM Department");

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentById(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Department department = session.get(Department.class, id);
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentByName(String name) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			query.setParameter("nameParameter", name);

			Department department = query.uniqueResult();
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();

			session.save(department);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentIdExists(short id) {
		Department department = getDepartmentById(id);

		if (department == null) {
			return false;
		}
		return true;
	}

	public boolean isDepartmentNameExists(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}

		return true;

	}
}
