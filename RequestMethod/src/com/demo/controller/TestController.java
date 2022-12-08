package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1_get() {
		return "test1";
	}
	
	@PostMapping("/test2")
	public String test2_post() {
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3_get() {
		return "test3_get";
	}
	
	@PostMapping("/test3")
	public String test3_post() {
		return "test3_post";
	}
	
	@RequestMapping("/test7")
	public String test7() {
		return "test7";
	}
}
