package tw.hibernatedemo.action;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Friend;
import tw.hibernatedemo.model.MyGroup;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoManyToManyFriendAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//只知道 group id 3 是工作群組
			MyGroup group3 = session.get(MyGroup.class, 3);
			
			Set<Friend> friendsInWorkGroup = group3.getFriends();
			
			Iterator<Friend> it = friendsInWorkGroup.iterator();
			
			while (it.hasNext()) {
				Friend friend = it.next();
				String friendName = friend.getFriendName();
				
				if(friendName.equals("Tina")) {
					it.remove();
				}
				
			}
			
			Friend friendbill = new Friend();
			friendbill.setFriendName("Bill");
			
			session.save(friendbill);
			
			friendsInWorkGroup.add(friendbill);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
		
	}

}
