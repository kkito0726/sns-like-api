package com.ken.snsLike.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthController {

	@GetMapping("/")
	public String hello() {
		return "Hello, Spring Boot!!";
	}
}
