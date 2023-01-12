package tw.leonchen.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Value("classpath:static/images/images005.jpg")
	private Resource resource;
	
	@GetMapping(path="/resource.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processResourceAction() throws IOException {
		File file1 = resource.getFile();
		System.out.println(file1.getName() + "\n" + file1.getPath() + "\n" + file1.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}
	
	@GetMapping(path = "/resourcespath.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processClassPathAction() throws IOException {
		Resource resource = new ClassPathResource("static/images/images001.jpg");
		File file1 = resource.getFile();
		System.out.println(file1.getName() + "\n" + file1.getPath() + "\n" + file1.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}

	@GetMapping(path = "/resourceloader.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processResourceLoaderAction() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:static/images/images003.jpg");
		File file1 = resource.getFile();
		System.out.println(file1.getName() + "\n" + file1.getPath() + "\n" + file1.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);		
	}
}
