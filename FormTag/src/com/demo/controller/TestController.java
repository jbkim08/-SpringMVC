package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.beans.DataBean;
import com.demo.beans.UserDataBean;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(UserDataBean bean) {
		
		bean.setUser_name("홍길동");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("주소1번입니다");
		bean.setUser_address2("주소 2번입니다");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(UserDataBean bean) {
		bean.setUser_name("홍길동");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_postcode("12345");
		bean.setUser_address1("주소1번입니다");
		bean.setUser_address2("주소 2번입니다");
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test1(DataBean bean) {

		bean.setA1("select2"); //select 
		
		String[] check_list = { "check1", "check3" }; //check box
		bean.setA2(check_list);	

		bean.setA3("radio2"); //radio

		return "test3";
	}
}
