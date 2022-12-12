package com.demo.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/save_cookie")
	public String save_cookie(HttpServletResponse response) {
		
		try {
			//쿠키에 입력할 한글을 인코딩해서 입력
			String data1 = URLEncoder.encode("문자열1", "UTF-8");
			String data2 = URLEncoder.encode("문자열2", "UTF-8");
			//새 쿠키 객체 생성
			Cookie cookie1 = new Cookie("cookie1", data1);
			Cookie cookie2 = new Cookie("cookie2", data2);
			//쿠키의 생존시간(초단위)
			cookie1.setMaxAge(365 * 24 * 60 * 60);
			cookie2.setMaxAge(365 * 24 * 60 * 60);
			//브라우저에 쿠키 추가(생성)
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "save_cookie";
	}
	
	@GetMapping("/load_cookie")
	public String load_cookie(HttpServletRequest request) {
		
		try {
			
			Cookie [] cookies = request.getCookies();
			
			for(Cookie cookie : cookies) {
				String str = URLDecoder.decode(cookie.getValue(), "UTF-8");
				
				if(cookie.getName().equals("cookie1")) {
					System.out.printf("cookie1 : %s\n", str);
				} else if(cookie.getName().equals("cookie2")) {
					System.out.printf("cookie2 : %s\n", str);
				}
					
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "load_cookie";
	}
	
}
