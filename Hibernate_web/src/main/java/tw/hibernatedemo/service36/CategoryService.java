package tw.hibernatedemo.service36;

import java.sql.SQLException;
import java.util.List;

import tw.hibernatedemo.model36.Category;


public interface CategoryService {

	void create(Category category) throws SQLException;

	void delete(int id) throws SQLException;

	void update(Category category) throws SQLException;

	Category select(int id) throws SQLException;

//    Category findImgByPdiD(int id);

	List<Category> selectAll() throws SQLException;
}
