package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDao;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyDaoEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		
		
		
		
		try {
			session.beginTransaction();
			
			CompanyDao dao = new CompanyDao(session);
			//建新資料
//			CompanyBean com1 = new CompanyBean();
//			com1.setCompanyId(1004);
//			com1.setCompanyName("運動彩券2");
//			dao.insertCompany(com1);
			
			//根據id搜尋
//			CompanyBean comResult = dao.findById(1002);
//			if(comResult != null) {
//				System.out.println("id: " + comResult.getCompanyId());
//				System.out.println("name: "+ comResult.getCompanyName());
//			}else {
//				System.out.println("沒有這筆資料");
//			}
			
			
			//測試update
//			Integer companyId = 1002; 
//			dao.updateoneCompany(companyId, "FTX(broken)");
			
			//測試delete v1
//			Integer companyId = 1003;
//			boolean result = dao.deleteCompany(companyId);
//			
//			if(result) {
//				System.out.println("刪除成功");
//			}else {
//				System.out.println("沒有這筆資料，刪除失敗");
//			}
					
			//測試delete v2
//			CompanyBean com2 = dao.findById(1004);
//			
//			boolean result = dao.deleteCompany(com2);
//			
//			if(result) {
//				System.out.println("刪除成功");
//			}else {
//				System.out.println("沒有這筆資料，刪除失敗");
//			}
			
			//找全部
			List<CompanyBean> result = dao.selectAll();
			
			for(CompanyBean com : result) {
				System.out.println("id: " + com.getCompanyId());
				System.out.println("name: " + com.getCompanyName());
			}
			
			session.getTransaction().commit();;
		} catch (Exception e) {
			System.out.println("rollback");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
