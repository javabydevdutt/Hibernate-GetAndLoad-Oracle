package com.devdutt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory = null;

	static {
		// Create Configuration class object
		Configuration cfg = new Configuration();

		// read and locate the hiberante.cfg.xml file
		cfg.configure("com/devdutt/cfgs/hibernate.cfg.xml");

		// create Session Factory object
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		Session ses = null;
		if (factory != null) {
			ses = factory.openSession();
		}
		return ses;
	}

	public static void closeSession(Session ses) {
		if (ses != null)
			ses.close();

	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();

	}
}
