package tw.leonchen.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebFilter("/*")
//@WebFilter(urlPatterns = "/*")
public class OpenSessionViewFilter implements Filter {

	private SessionFactory factory;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext application = filterConfig.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		factory = context.getBean("sessionFactory", SessionFactory.class);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			System.out.println("transaction begin");

			chain.doFilter(req, resp);

			session.getTransaction().commit();
			System.out.println("transation commit");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("transation rollback");
		} finally {
			System.out.println("session closed");
		}
	}

}
