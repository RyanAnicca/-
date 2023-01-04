package tw.hibernatedemo.controller36.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.hibernatedemo.model36.Category;
import tw.hibernatedemo.service36.impl.CategoryServiceImpl;


@MultipartConfig()
@WebServlet("/CategorySelectByPdidServlet.do")
public class CategorySelectByPdidServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		int parameter = Integer.parseInt(req.getParameter("pdid"));
		System.out.println(parameter);
		CategoryServiceImpl cgS = new CategoryServiceImpl();

		Category select;
		try {
			select = cgS.select(parameter);
			req.setAttribute("Category", select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/Pd_update.jsp");
		rd.forward(req, resp);
		return;

	}

}
