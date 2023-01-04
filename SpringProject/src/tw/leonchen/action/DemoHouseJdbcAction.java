package tw.leonchen.action;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.House;
import tw.leonchen.model.HouseService;

public class DemoHouseJdbcAction {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		HouseService houseService = context.getBean("houseService", HouseService.class);
		House resoultBean = houseService.selectById(1003);

		if (resoultBean != null) {
			System.out.println(resoultBean.getHouseid() + " " + resoultBean.getHousename());
		} else {
			System.out.println("not result");
		}

		context.close();
	}

}
