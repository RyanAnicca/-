package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorEx5 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			//假設instructor 的id 為 1,又回來了,detail要加回去
			Instructor ins1 = session.get(Instructor.class, 1);
			
			//new detail
			InstructorDetail detail = new InstructorDetail();
			detail.setEmail("Ryan@gmail");
			detail.setPhone("66666");
			
			//save
			session.save(detail);
			
			//set給 Instructor
			ins1.setInstructorDetail(detail);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
		
		
	}

}
