package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("/WEB-INF/properties/data1.properties")
public class TestController {

	@Value("${oracle.user}")
	private String oracle_user;
	
	@Value("${oracle.pass}")
	private String oracle_pass;
	
	@Value("${secret.number}")
	private int secret_number;
	
    //MessageSource를 주입받는다.
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	
	@GetMapping("/test1")
	public String test1() {
		
		System.out.printf("oracle.user : %s\n", oracle_user);
		System.out.printf("oracle.pass : %s\n", oracle_pass);
		System.out.printf("secret.number : %d\n", secret_number);
		
		String m1 = messageSource.getMessage("oracle.user", null, null);
		System.out.println(m1);
		
		String m2 = messageSource.getMessage("mysql.user", null, null);
		System.out.println(m2);
		String m3 = messageSource.getMessage("mysql.pass", null, null);
		System.out.println(m3);

		
		return "test1";
	}

}
