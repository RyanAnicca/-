package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Person;

@RestController
public class PersonController {

	@Autowired
	private Person person;

	@GetMapping("/person.controller")
	public Person processAction() {
		return person;
	}
}
