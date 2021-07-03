package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.HibernateUtils;

public class PositionRepository {
	HibernateUtils hibernateUtils;
	
	public PositionRepository() {
		hibernateUtils =  HibernateUtils.getInstance();
	}
	
	public List<Position> getListPosition() {
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			Query<Position> query = session.createQuery("FROM Position ORDER BY id");
			
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Position getPositionById(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Position position = session.get(Position.class, id);
			
			return position;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Position getPositionByName(String name) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Position> query = session.createQuery("FROM Position WHERE name = :nameParameter");
			query.setParameter("nameParameter", name);
			Position position = query.uniqueResult();
			return position;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public boolean isPositionExistsById(short id) {

		Position position = getPositionById(id);
		if (position != null) {
			return true;
		}
		return false;
	}
	
	public boolean isPositionExistsByName(String name) {

		Position position = getPositionByName(name);
		if (position != null) {
			return true;
		}
		return false;
	}

}
