package tw.hibernatedemo.controller36.servlet;


import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.hibernatedemo.model36.Category;
import tw.hibernatedemo.service36.CategoryService;
import tw.hibernatedemo.service36.impl.CategoryServiceImpl;


@WebServlet("/CategoryCreateServlet.do")
public class CategoryCreateServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Category category = (Category) req.getAttribute("category");

        CategoryService categoryService = new CategoryServiceImpl();
        try {
			categoryService.create(category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
