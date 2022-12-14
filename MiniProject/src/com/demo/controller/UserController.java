package com.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;

	@GetMapping("/login")
	public String login(@ModelAttribute("loginBean") LoginUserBean loginBean, Model model,
						@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
		model.addAttribute("fail", fail);
		return "user/login";
	}
	
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("loginBean") LoginUserBean loginBean, 
							BindingResult result) {		
		if(result.hasErrors()) {
			return "user/login";
		}
		//유효성테스트 완료후 id pw로 현재 로그인 유저정보를 DB에서 꺼내와 세션에 로그인객체에 저장한다.
		userService.getLoginUserInfo(loginBean);
		
		if(loginUserBean.isUserLogin() == true) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}
		
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, 
							BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "user/join";
		}
		if(!joinUserBean.getUser_pw().equals(joinUserBean.getUser_pw2())) {
			model.addAttribute("msg", "비밀번호가 같지 않습니다.");
			return "user/join";
		}
		userService.addUserInfo(joinUserBean); //DB에 유저 저장
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean) {
		//현재 로그인중인 loginUserBean에서 아이디와 이름값을 얻어 modifyUserBean에 넣기
		userService.getModifyUserInfo(modifyUserBean);
		return "user/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyUserBean") UserBean modifyUserBean, 
							 BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "user/modify";
		}
		if(!modifyUserBean.getUser_pw().equals(modifyUserBean.getUser_pw2())) {
			model.addAttribute("msg", "비밀번호가 같지 않습니다!");
			return "user/modify";
		}
		
		//DB에 수정된 비밀번호 저장하기
		userService.modifyUserInfo(modifyUserBean);
		return "user/modify_success";
	}
	
	@GetMapping("/logout")
	public String logout() {
		loginUserBean.setUserLogin(false);
		return "user/logout";
	}
	
	@GetMapping("/not_login")
	public String not_login() {
		return "user/not_login";
	}
}
