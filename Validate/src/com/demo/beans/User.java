package com.demo.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	
	@NotBlank(message = "id를 입력해 주세요")
	private String id;
	
	@Size(min = 4, max = 6, message = "패스워드는 4~6자 입니다.")
	private String pass;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	
}
