package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Bird;
import tw.leonchen.model.BirdService;

@RestController
public class BirdController {

	@Autowired
	private BirdService bService;
	
	@GetMapping("/insert/controller")
	public Bird processInsertAction() {
		Bird b1 = new Bird("mockingjay","red","M",14);
		return bService.insert(b1);
	}
	
	@PostMapping("/birdinsert2/controller")
	public Bird processInsertAction2(@RequestBody Bird b3) {
		return bService.insert(b3);
	}
	
	@GetMapping("/birddelete.controller")
	public String processDeleteByIdAction() {
		bService.deleteById(102);
		return "ok";
	}
	
	@GetMapping("/birdquerybyid.controller")
	public Bird processFindByIdAction() {
		return bService.findById(102);
	}
	
	@GetMapping("/birdupdate.controller")
	public Bird processUpdateAction() {
		Bird b2 = new Bird(102, "mockingjay","red","M",11);
		return bService.update(b2);
	}
	
	
	
}
