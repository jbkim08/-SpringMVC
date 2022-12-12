package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.demo.beans.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpSession session) {
		session.setAttribute("data1", "문자열1");

		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data1", "문자열2");
		return "redirect:/result1";
	}

	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data1", "문자열3");
		return "forward:/result1";
	}
	
	
	@GetMapping("/result1")
	public String result1(HttpSession session) {
		String data1 = (String) session.getAttribute("data1");

		System.out.printf("data1 : %s\n", data1);
		return "result1";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		session.setAttribute("bean1", bean1);		
		return "result2";
	}
	
	@GetMapping("/result2")
	public String result4(@SessionAttribute("bean1") DataBean1 bean1) {
			
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result2";
	}
}
