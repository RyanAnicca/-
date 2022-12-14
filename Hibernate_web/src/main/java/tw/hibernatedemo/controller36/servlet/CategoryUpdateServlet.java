package tw.hibernatedemo.controller36.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.hibernatedemo.model36.Category;
import tw.hibernatedemo.service36.CategoryService;
import tw.hibernatedemo.service36.impl.CategoryServiceImpl;


// 更新產品資料，邏輯上與新增資料類似
@MultipartConfig()
@WebServlet("/CategoryUpdateServlet.do")
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			String userID = req.getParameter("userID");
			String Pdname = req.getParameter("Pdname");
			String Pdtitle = req.getParameter("Pdtitle");
			String Pdcontent = req.getParameter("Pdcontent");
			String Pdtype = req.getParameter("Pdtype");
			int Pdprice = Integer.parseInt(req.getParameter("Pdprice"));
			int Pdinventory = Integer.parseInt(req.getParameter("Pdinventory"));

			Date datelastup = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(req.getParameter("Pdlastupdate"));
			Date Pdlastupdate = datelastup;
			Integer Pdid = Integer.parseInt(req.getParameter("Pdid"));

			CategoryService categoryService = new CategoryServiceImpl();
			Category bean = new Category(Pdid, userID, Pdname, Pdtitle, Pdcontent, Pdtype, null, Pdprice, Pdinventory,null,
					Pdlastupdate);

			categoryService.update(bean);

			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath + "/T4_36/html5up-editorial/Pd_ok.jsp");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}