package tw.hibernatedemo.controller36.servlet;


import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.hibernatedemo.service36.CategoryService;
import tw.hibernatedemo.service36.impl.CategoryServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@MultipartConfig()
@WebServlet("/CategoryDeleteServlet.do")
public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
		String ProductId = req.getParameter("ProductId");

		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.delete(Integer.parseInt(ProductId));

		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath + "/Pd_ok.jsp");
		} catch (IOException | NumberFormatException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
