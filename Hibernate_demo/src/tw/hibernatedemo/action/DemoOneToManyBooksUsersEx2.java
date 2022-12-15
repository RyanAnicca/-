package tw.hibernatedemo.action;


import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.model.BooksUsers;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToManyBooksUsersEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// booksusers id 為1,想知道他借了哪些書
			BooksUsers user1 = session.get(BooksUsers.class, 1);
			
			Set<Books> books = user1.getBooks();
			
//			Iterator<Books> it = books.iterator();
			
//			while (it.hasNext()) {
//				Books onebook = it.next();
//				System.out.println("title" + onebook.getBooktitle());
//				
//			}
			
			for(Books oneBook:books) {
				System.out.println("借了"+ oneBook.getBooktitle());
				
			}
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
