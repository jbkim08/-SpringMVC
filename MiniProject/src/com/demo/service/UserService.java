package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public boolean checkuserIdExist(String user_id) {
		
		String user_name = userMapper.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;  //가입가능
		} else {
			return false; //동일한 아이디가 있음
		}
	}

}
