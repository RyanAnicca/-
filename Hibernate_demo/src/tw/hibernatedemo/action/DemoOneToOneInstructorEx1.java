package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			Instructor ins1 = new Instructor();
			ins1.setName("Ryan2");
			
			InstructorDetail detail1 = new InstructorDetail();
			detail1.setEmail("Ryan2@gmail");
			detail1.setPhone("123456666");
			
			ins1.setInstructorDetail(detail1);
			
			session.beginTransaction();
			
			//因為有做 cascade連動，所以 detail1 也會一起轉到 Persisent 狀態
//			session.save(detail1); //若沒有做cascade連動，兩邊都要做save，關聯主鍵那一邊要先存在
			session.save(ins1);
			
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
