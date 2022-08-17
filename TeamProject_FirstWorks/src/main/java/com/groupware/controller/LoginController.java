package com.groupware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.dto.MemberDTO;
import com.groupware.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller

public class LoginController {
	@Setter(onMethod_ = { @Autowired })

	public MemberService service;

	@GetMapping("/login/Login_form")
	public void login(MemberDTO member) {

	}

	@PostMapping("/login/login")
	public String loginpro(MemberDTO member) throws Exception {
		if (service.login(member) == 1) {

			return "redirect:/main";
		} else {
			return "redirect:/login/Login_form";
		}
	}

//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		log.info("logout start");
//		session.removeAttribute("mem_id");
//		log.info("logout successed");
//		return "redirect:/login/Login";
//	}
}
