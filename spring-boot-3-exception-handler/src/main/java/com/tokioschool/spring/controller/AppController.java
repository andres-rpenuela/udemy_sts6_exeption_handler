package com.tokioschool.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	//http://localhost:8081/ok
	@GetMapping("/ok")
	public String getNumberHandler() {
		return "200 ok";
	}
	
	// http://localhost:8081/divide?a=3&b=5
	@GetMapping("/divide")
	public String getDivideHandler(@RequestParam(value="a") Double a, @RequestParam(value="b") Double b) {
		if(b == 0) {
			throw new NumberFormatException("Don't divide by 0");
		}
		double result = a/b;
		return "%3.3g / %3.3g = %3.3g".formatted(a,b,result);
	}
}
