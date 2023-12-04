package com.spring.gta.detail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailController {
	@RequestMapping("/detail")
	public String dashBoardList(Model model) {
		
		return "detail/detail";
	}
}
