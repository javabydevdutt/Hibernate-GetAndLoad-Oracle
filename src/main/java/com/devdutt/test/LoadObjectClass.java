package com.devdutt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.devdutt.entity.Employee;
import com.devdutt.utils.HibernateUtil;

public class LoadObjectClass {

	public static void main(String[] args) {
		Session ses = null;
		Employee emp = null;
		// Create Session object
		ses = HibernateUtil.getSession();
		try {
			emp = ses.load(Employee.class, 113);

			if (emp != null) {
				System.out.println(emp.getEid() + " " + emp.getEname() + " " + emp.getEmail() + " " + emp.getSalary());
			} // if
			else {
				System.out.println("No Record Found");
			} // else
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} // catch

		finally {
			// close the sessions
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		} // finally
	}// main
}
