package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyBeanEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			CompanyBean com1 = session.get(CompanyBean.class, 1001);

			System.out.println("id: " + com1.getCompanyId());
			System.out.println("name: " + com1.getCompanyName());

//			公司名稱改成Alphabet
			com1.setCompanyName("Alphabet");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Rollback");
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
