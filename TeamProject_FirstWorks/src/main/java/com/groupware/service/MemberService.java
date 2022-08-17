package com.groupware.service;



import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupware.dto.MemberDTO;

//개잍
public interface MemberService {

	//로그인

	
	//회원가입
	public void register(MemberDTO member);
	
	//회원삭제
	public boolean memberdelete(String mem_no);
	
	//회원 정보 수정
	public boolean memberupdate(MemberDTO member);


	int login(MemberDTO member) throws Exception;





}
