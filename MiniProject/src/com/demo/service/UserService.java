package com.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;
	
	public boolean checkuserIdExist(String user_id) {
		
		String user_name = userMapper.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;  //가입가능
		} else {
			return false; //동일한 아이디가 있음
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userMapper.addUserInfo(joinUserBean);
	}
	
	//로그인이 되었을때 유저객체에 정보를 저장한다.
	public void getLoginUserInfo(LoginUserBean loginBean) {
		
		LoginUserBean tempLoginBean = userMapper.getLoginUserInfo(loginBean);
		
		//로그인유저객체에 현재 로그인된 유저의 정보를 입력한다. 로그인상태는 true로 입력
		if(tempLoginBean != null) {
			loginUserBean.setUser_idx(tempLoginBean.getUser_idx());
			loginUserBean.setUser_name(tempLoginBean.getUser_name());
			loginUserBean.setUserLogin(true); //로그인 상태 true
		} else {
			loginUserBean.setUserLogin(false); //로그인 상태 false
		}
	}

}
