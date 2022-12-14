package tw.hibernatedemo.model36;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

	// 新增一筆記錄
	Category insert(Category category) throws SQLException;

	// 依Pd_id來刪除單筆記錄
	Boolean deleteByPd_id(int id) throws SQLException;

	void update(Category category) throws SQLException;

	Category selectByPdid(int Pdid) throws SQLException;

	List<Category> selectAll() throws SQLException;

//	Category findImgByPdiD(int id) throws SQLException;

}
