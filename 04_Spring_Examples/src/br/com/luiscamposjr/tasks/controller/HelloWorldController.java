package br.com.luiscamposjr.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/helloWorldSpring")
	public String execute() {
		System.out.println("Executando Spring MVC Test");
		return "ok";
	}

}
