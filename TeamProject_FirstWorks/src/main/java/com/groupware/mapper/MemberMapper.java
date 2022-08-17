package com.groupware.mapper;

import com.groupware.dto.MemberDTO;

//개인
public interface MemberMapper {
	
	
	//로그인
	public int login(MemberDTO member) throws Exception;
	
	public MemberDTO memdetail(MemberDTO member);
	//회원가입
	public void register(MemberDTO member)throws Exception;
	
	//회원삭제
	public String memberdrop(String mem_id);
	//회원 수정
	public int memberupdate(MemberDTO member);
	//비밀번호 체크
	public boolean checkpw(String mem_pw);
	//마이페이지 info
	public MemberDTO memberinfo(String mem_id);
	
}


