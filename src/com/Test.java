package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.domain.userInfo;;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInfo user = new userInfo();
		user.setId(1);
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
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
