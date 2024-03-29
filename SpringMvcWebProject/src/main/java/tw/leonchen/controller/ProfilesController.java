package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfilesController {
	
	@PostMapping("/profiles.controller")
	@ResponseBody
	public String processAction(@RequestParam("userName") String userName, @RequestParam("userAddress") String userAddress,
			                    @RequestParam("userPhone") String userPhone) {
		return "message:" + userName + "-" + userAddress + "-" + userPhone;
	}
	
	@PostMapping("/profiles2.controller")
	@ResponseBody
	public String processAction2(@RequestParam("userName") String userName) {
		return "message:" + userName;
	}

}
