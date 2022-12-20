package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.beans.ContentBean;
import com.demo.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;

	@GetMapping("/main")
	public String main(Model model) {
		
		ArrayList<List<ContentBean>> list = new ArrayList<List<ContentBean>>();
		
		list.add(mainService.getMainList(1)); //게시판 1번 자유게시판 5개 게시글 리스트 추가
		list.add(mainService.getMainList(2)); //게시판 2번 유머게시판 5개 게시글 리스트 추가
		list.add(mainService.getMainList(3)); //게시판 3번 정치게시판 5개 게시글 리스트 추가
		list.add(mainService.getMainList(4)); //게시판 4번 스포츠게시판 5개 게시글 리스트 추가
		
		model.addAttribute("list", list);

		return "main";
	}

}
