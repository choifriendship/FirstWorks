package com.groupware.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Mem_dto;
import com.groupware.dto.MemberDTO;
import com.groupware.dto.Pagedto;

public interface GroupwareService {
	public List<Mem_dto> test();
	
////	휴가신청서 입력
//	public void apv_vc_insert(Apv_vc_dto board);
//
////	휴가신청서 리스트 불러오기(사원번호)
//	public List<Apv_vc_dto> apv_vc_list(Apv_vc_dto board);
//
////	휴가신청서 불러오기(문서번호)
//	public Apv_vc_dto apv_vc_detail(Apv_vc_dto board);
//
////	시간외근무 신청서 입력
//	public void apv_over_insert(Apv_over_dto board);
//
////	시간외근무 신청서 리스트 불러오기(사원번호)
//	public List<Apv_over_dto> apv_over_list(Apv_over_dto board);
//
////	시간외근무 신청서 리스트 불러오기(문서번호)
//	public Apv_over_dto apv_over_detail(Apv_over_dto board);

	public void stampupload(MultipartFile[] filename,HttpSession session);

	public Apv_vc_dto stamp(Apv_vc_dto board);
	
	public void logout(HttpSession session);
	
	public void login(int mem_no, HttpSession session);
	
	public void vc_insert(Apv_vc_dto dto,HttpSession session);
	
	public List<Apv_vc_dto> waitinglist(Map map);
	
	public List<Apv_vc_dto> waitinglist1(Map map);
	
	public List<Apv_vc_dto> waitinglist2(Map map);
	
	public Apv_vc_dto waitinglistdetail(int apv_no);
	
	public void twocf(HttpSession session,int apv_no);
	
	public void threecf(HttpSession session, int apv_no);
	
	public List<Apv_vc_dto> cflist(Map map);
	
	public int cflistcount(Map map);
	
	public int cflistallcount(Map map);
	
	public List<Apv_vc_dto> cflistall(Map map);
	
	public Apv_vc_dto cfdetail(int apv_no);
	
	public int watingcount(Map map);
	
	public int watingcount1(Map map);
	
	public int watingcount2(Map map);
	
	public void vc_inserttwo(Apv_vc_dto dto,HttpSession session);
	
	public void vc_insertthree(Apv_vc_dto dto,HttpSession session);
	
	public void rej(Apv_vc_dto dto);
	
	public List<Apv_vc_dto> rejlist(Map map);
	
	public int rejlistcount(Map map);
	
	public Apv_vc_dto rejdetail(int apv_no);
	
	public void delrej(Apv_vc_dto dto);
	
	public void retrypro(Apv_vc_dto dto,HttpSession session);
	
	public List<Apv_vc_dto> watingmyapv(Map map);
	
	public int mywating(Map map);
	
	public void include(Model m);
	
	public Mem_dto mydetail();
	
}
