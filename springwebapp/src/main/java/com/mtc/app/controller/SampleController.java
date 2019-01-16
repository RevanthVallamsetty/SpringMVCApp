package com.mtc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@RequestMapping("/greetings")
	public @ResponseBody String greet() {
		return "Welcome to Spring Framework!";
	}
	
}
