package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.DataBaseProperties;

@RestController
public class DataBasePropertiesController {
	
	@Autowired
	private DataBaseProperties dp1;
	
	@GetMapping("/databaseproperties.controller")
	public DataBaseProperties processAction() {
		return dp1;
	}

}
