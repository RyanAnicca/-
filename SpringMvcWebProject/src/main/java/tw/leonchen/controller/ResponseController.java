package tw.leonchen.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class ResponseController {

	@GetMapping(path = "/response1.controller")
	@ResponseBody
	public String processResponseAction1() {
		return "something went wrong, really ,出了點問題， 真的";
	}

	@GetMapping(path = "/response2.controller", produces = "text/plan;charset=UTF-8")
	@ResponseBody
	public String processResponseAction2() {
		return "something went wrong, really ,出了點問題， 真的";
	}

	@GetMapping(path = "/responsestatus.controller")
	public ResponseEntity<String> processStatusAction() {
		return new ResponseEntity<String>("custom status code(403 forbidden)", HttpStatus.FORBIDDEN);
	}

	@GetMapping(path = "/responseimage.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processByteArrayImageAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images001.jpg");
		return IOUtils.toByteArray(in);
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		return cmr;
	}
}
