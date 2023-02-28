package com.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.models.User;
import com.utils.HibernateUtil;

public class UserDAO {
	public static User getUser(String id) {
        Transaction transaction = null;
        Session session = null;
        User user = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
        	if(session != null) {
        		session.close();
        	}
        }
        return user;
    }
	public static void insertUser(User user) {
		Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
        	if(session != null) session.close();
//        	if(sessionFactory != null) sessionFactory.close();
        }
	}
	public static void updateUser(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
        	if(session != null) session.close();
        }
    }
	public static void main(String[] args) {
//		User user = new User();
//		user.setEmail("aakanshaprasad01@gmail.com");
//		user.setName("Aakansha Prasad");
//		user.setPassword("12345");
//		user.setType("student");
//		user.setId("18700220055");
//		insertUser(user);
	}
}
