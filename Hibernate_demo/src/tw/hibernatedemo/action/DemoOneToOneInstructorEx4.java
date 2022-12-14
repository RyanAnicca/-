package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorEx4 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			//假設只知道instructor 的id 為 1,不想留下detail的資料
			Integer insId = 1;
			Instructor ins = session.get(Instructor.class, insId);
			//先拿到另一邊(detail)
			InstructorDetail detail = ins.getInstructorDetail();
			System.out.println("email: " + detail.getEmail() + "phone: " + detail.getPhone());
			//set null
			ins.setInstructorDetail(null);
			
			//delete detail
			session.delete(detail);
			
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
