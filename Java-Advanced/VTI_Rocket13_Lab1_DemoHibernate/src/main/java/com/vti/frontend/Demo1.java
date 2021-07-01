package com.vti.frontend;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.TestingCategory;

public class Demo1 {
	public static void main(String[] args) {
		Session session = null;
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();
			
			TestingCategory testing = new TestingCategory();
			testing.setName("Category Testing");
			session.save(testing);
			
			Query<TestingCategory> query = session.createQuery("FROM TestingCategory");
			List<TestingCategory> list = query.list();
			for (TestingCategory testingCategory : list) {
				System.out.println("ID: " + testingCategory.getId() + ", Name : " + testingCategory.getName());
			}
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(TestingCategory.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}
}
