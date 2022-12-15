package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentEx3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Department dept = new Department("Sells");
		
		Serializable id = session.save(dept);
		
		System.out.println("id: "+ id);
		
		session.getTransaction().commit();
		
		session.close();
		
		HibernateUtil.closeSessionFactory();
		
		
	}

}
