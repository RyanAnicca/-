package tw.hibernatedemo.action;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.model.BooksUsers;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToManyBooksUsersEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//new User
			BooksUsers user1 = new BooksUsers();
			user1.setUsername("館長");
			
			
			//new book1
			Books book1 = new Books();
			book1.setBooktitle("Java 王者歸來");
			book1.setPublicYear("2020-1");
			
			//new book2
			Books book2 = new Books();
			book2.setBooktitle("SQL 九九種解法");
			book2.setPublicYear("2022-2");
			
			//book set user
			book1.setBooksusers(user1);
			book2.setBooksusers(user1);
			
			//user set book
			Set<Books> books = new LinkedHashSet<Books>();
			books.add(book1);
			books.add(book2);
			
			
			user1.setBooks(books);
			
			//save user : 有 cascade 另一邊的設定
			session.save(user1);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
