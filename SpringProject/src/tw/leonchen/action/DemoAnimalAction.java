package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.Animal;
import tw.leonchen.model.AnimalService;

public class DemoAnimalAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		Animal animal = context.getBean("animal", Animal.class);
		animal.setId(1);
		animal.setName("elephant");
		animal.setContinent("asia");
		System.out.println(animal.getId() + " " + animal.getName() + " " + animal.getContinent());

		AnimalService aService = context.getBean("aService",AnimalService.class);
		aService.showInfo();
		
		context.close();
	}

}
