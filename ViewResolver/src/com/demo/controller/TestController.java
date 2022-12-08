package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.DataBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		request.setAttribute("data1", 100);
		request.setAttribute("data2", 200);

		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(Model model) {
		
		model.addAttribute("data1", 100);
		model.addAttribute("data2", 200);

		return "test3";
	}
	
	@GetMapping("/test4")
	public ModelAndView test4(ModelAndView mv) {
		
		mv.addObject("data1", 500);
		mv.addObject("data2", 600);
		
		mv.setViewName("test4");

		return mv;
	}
	
	@PostMapping("/test5")
	public String test1(DataBean bean) {
		return "test5";
	}
}
