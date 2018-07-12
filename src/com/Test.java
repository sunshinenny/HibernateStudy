package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.testing.junit.*;

import com.domain.userInfo;;

public class Test {
	public static void main(String[] args) {
		saveToDatabase();
		// findFromDatabase();//success
		// deleteDatabase();//success
	}

	static void saveToDatabase() {
		userInfo user = new userInfo();
		user.setUserId(100);
		user.setPassword("pleasePass");
		// 1.初始化,读取配置文件
		Configuration config = new Configuration().configure();
		// 2.读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.打开session
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			// 4.开始一个事务
			tx = session.beginTransaction();
			// 5.持久化操作
			session.save(user);
			// 6.commit
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
				System.out.println("Exception runned");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	static void findFromDatabase() {
		// userInfo user = new userInfo();
		// 1.初始化,读取配置文件
		Configuration config = new Configuration().configure();
		// 2.读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.打开session
		Session session = sessionFactory.openSession();
		userInfo findResult = (userInfo) session.get(userInfo.class, new Integer(1));
		System.out.println(findResult.getPassword());
	}

	static void deleteDatabase() {
		// userInfo user = new userInfo();
		// 1.初始化,读取配置文件
		Configuration config = new Configuration().configure();
		// 2.读取创建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.打开session
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		userInfo findResult = (userInfo) session.get(userInfo.class, new Integer(2));
		try {
			tx = session.beginTransaction();
			session.delete(findResult);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
