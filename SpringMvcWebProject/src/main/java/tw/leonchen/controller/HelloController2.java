package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(names = { "username" })
public class HelloController2 {

	@RequestMapping(path = "/hello2main.controller", method = RequestMethod.GET)
	public String processMainAction() {
		return "form";
	}
	
	@RequestMapping(path = "/hello2.controller", method = RequestMethod.GET)
	public String processAction1(@RequestParam("username") String userName, Model m, SessionStatus status) {
		// String userName = request.getParameter("userName");

		Map<String, String> errors = new HashMap<String, String>();

		// request.setAttribute("errors", errors);
		m.addAttribute("errors", errors); // request scope

		if (userName == null || userName.length() == 0) {
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			return "form";
		}

		// HttpSession session = request.getSession();
		// session.setAttribute("username", userName);
		status.setComplete();
		m.addAttribute("username", userName);
		return "success";
	}

	@RequestMapping(path = "/hello2.controller", method = RequestMethod.POST)
	public String processAction2(@RequestParam("username") String userName, Model m, SessionStatus status) {
		// String userName = request.getParameter("userName");

		Map<String, String> errors = new HashMap<String, String>();

		// request.setAttribute("errors", errors);
		m.addAttribute("errors", errors); // request scope

		if (userName == null || userName.length() == 0) {
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			return "form";
		}

		// HttpSession session = request.getSession();
		// session.setAttribute("username", userName);
		status.setComplete();
		m.addAttribute("username", userName);
		return "success";
	}

}
