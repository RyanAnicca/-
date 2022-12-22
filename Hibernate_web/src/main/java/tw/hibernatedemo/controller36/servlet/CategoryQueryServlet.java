package tw.hibernatedemo.controller36.servlet;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.hibernatedemo.model36.Category;
import tw.hibernatedemo.service36.CategoryService;
import tw.hibernatedemo.service36.impl.CategoryServiceImpl;

@WebServlet("/CategoryQueryServlet.do")
public class CategoryQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		CategoryService cgS = new CategoryServiceImpl();
		
		try {
			Category category = cgS.select(Integer.parseInt(id));
			req.setAttribute("querybyproductno", category);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/SHOP_DETAIL/ProductQuery_Result.jsp");
		rd.forward(req, resp);
		return;
    }
}
