package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.model.Employee;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoHQLActionEx1 {

	public void hqlDemo1() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			String hql = "from Employee";
			
			Query<Employee> query = session.createQuery(hql, Employee.class);
			
			List<Employee> resultList = query.getResultList();
			
			for (Employee emp : resultList) {
				System.out.println(emp);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	public void findEmployeeBySalaryAndVacation(Integer salary, Integer vacation) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			String hql = "from Employee where salary > :s and vacation > :v";
			
			Query<Employee> query = session.createQuery(hql, Employee.class)
					.setParameter("s", salary)
					.setParameter("v", vacation);
			
			List<Employee> resultList = query.getResultList();
			
			for (Employee emp : resultList) {
				System.out.println(emp);
			}
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}
	
	//透過name找人
	public void findByName(String name) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			String hql = "from Employee where empName = :name";
			
			Query<Employee> query = session.createQuery(hql, Employee.class)
					.setParameter("name", name);
			
			List<Employee> resultList = query.getResultList();
			
			for (Employee emp : resultList) {
				System.out.println(emp);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

		
		
	}
	
	public void updateSalaryByName(String name, Integer newSalary) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			String hql = "update Employee set salary = ?1 where empName = ?2";
			
			session.createQuery(hql)
					.setParameter(1, newSalary)
					.setParameter(2, name)
					.executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}
	
	public void likeSearch(String namePart) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			String hql = "from Employee where empName like :name";
			
			Query<Employee> query = session.createQuery(hql, Employee.class)
					.setParameter("name", "%" + namePart + "%");
			
			List<Employee> resultList = query.getResultList();
			
			for (Employee emp : resultList) {
				System.out.println(emp);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public static void main(String[] args) {
		DemoHQLActionEx1 hqlDemo = new DemoHQLActionEx1();
//		hqlDemo.hqlDemo1();
//		hqlDemo.findEmployeeBySalaryAndVacation(30000, 10);
//		hqlDemo.findByName("Mary");
//		hqlDemo.updateSalaryByName("Betty", 55000);
		hqlDemo.likeSearch("o");
	}

}
