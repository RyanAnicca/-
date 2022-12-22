package tw.hibernatedemo.service36.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import tw.hibernatedemo.model36.Category;
import tw.hibernatedemo.model36.CategoryDao;
import tw.hibernatedemo.model36.CategoryDaoImpl;
import tw.hibernatedemo.service36.CategoryService;
import tw.hibernatedemo.util.HibernateUtil;




public class CategoryServiceImpl implements CategoryService {

	
	private final CategoryDao categoryDao = new CategoryDaoImpl(HibernateUtil.getSessionFactory().getCurrentSession());

	public CategoryServiceImpl(Session session) {
	}

	@Override
	public void create(Category category) throws SQLException {
		categoryDao.insert(category);
	}

	@Override
	public void delete(int id) throws SQLException {
		categoryDao.deleteByPd_id(id);
	}

	@Override
	public void update(Category category) throws SQLException {
		categoryDao.update(category);
	}

	@Override
	public Category select(int id) throws SQLException {
		Category category = categoryDao.selectByPdid(id);
		return category;
	}

	// 透過PdiD秀圖片
//	@Override
//	public Category findImgByPdiD(int id) {
//		try {
//			DbUtils.begin();
//			Category cg = categoryDao.findImgByPdiD(id);
//			DbUtils.commit();
//			return cg;
//		} catch (SQLException e) {
//			DbUtils.rollbacl();
//			e.printStackTrace();
//			return null;
//		}
//	}

	@Override
	public List<Category> selectAll() throws SQLException {
		List<Category> categoryList = categoryDao.selectAll();
		return categoryList;
	}
}
