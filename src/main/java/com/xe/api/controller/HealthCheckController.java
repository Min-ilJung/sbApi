package com.xe.api.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	
	@GetMapping("/healthy")
	public String healthy(HttpServletRequest request) {
		String path = System.getProperty("user.dir");
		return "{\"status\":\"UP\",\"path\":\""+path+"\"}";
	}
}
