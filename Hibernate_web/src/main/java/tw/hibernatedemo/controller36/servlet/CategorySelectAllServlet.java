package tw.hibernatedemo.controller36.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model36.Category;
import tw.hibernatedemo.service36.CategoryService;
import tw.hibernatedemo.service36.impl.CategoryServiceImpl;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/SelectAllServlet.do")
public class CategorySelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		CategoryService cgS = new CategoryServiceImpl(session);

		List<Category> list = null;
		try {
			list = cgS.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("AllList", list);

		RequestDispatcher rd = req.getRequestDispatcher("/Pd_Allproduct.jsp");
		rd.forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req, resp);
	}
}
