package com.groupware.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Mem_dto;
import com.groupware.dto.MemberDTO;
import com.groupware.dto.Pagedto;
import com.groupware.mapper.Boardmapper;
import com.groupware.mapper.MemberMapper;

@Service
public class GroupwareServiceimpl implements GroupwareService {
	@Autowired
	Boardmapper mapper;
	@Autowired
	HttpSession session;
	@Autowired
	MemberMapper m;
	
	public List<Mem_dto> test() {
		return mapper.test();
	}	

//	휴가신청서 입력
//	public void apv_vc_insert(Apv_vc_dto board) {		
//		mapper.apv_vc_insert(board);
//	}
//
////	휴가신청서 리스트 불러오기(사원번호)
//	public List<Apv_vc_dto> apv_vc_list(Apv_vc_dto board) {
//		return mapper.apv_vc_list(board);
//	}
//
////	휴가신청서 불러오기(문서번호)
//	public Apv_vc_dto apv_vc_detail(Apv_vc_dto board) {
//		return mapper.apv_vc_detail(board);
//	}
//
////	시간외근무 신청서 입력
//	public void apv_over_insert(Apv_over_dto board) {
//		mapper.apv_over_insert(board);
//	}
//
////	시간외근무 신청서 리스트 불러오기(사원번호)
//	public List<Apv_over_dto> apv_over_list(Apv_over_dto board) {
//		return mapper.apv_over_list(board);
//	}
//
////	시간외근무 신청서 불러오기(문서번호)
//	public Apv_over_dto apv_over_detail(Apv_over_dto board) {
//		return mapper.apv_over_detail(board);
//	}
//	도장업로드 처리
	public void stampupload(MultipartFile[] filename,HttpSession session) {
		int mem_no = (Integer)session.getAttribute("mem_no");
		String uploadFolder = "C:\\upload";
		for(MultipartFile multi : filename) {			
			File saveFile = new File(uploadFolder,multi.getOriginalFilename());			
			try {
				mapper.stampupload(multi.getOriginalFilename(),mem_no);
				multi.transferTo(saveFile);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	public Apv_vc_dto stamp(Apv_vc_dto board) {
		return mapper.getstamp(board);
	}
	public void login(int mem_no, HttpSession session) {
		session.setAttribute("mem_no", mem_no);	
		session.setAttribute("lev", mapper.getrank(mem_no)); 
	}
	public void logout(HttpSession session) {
		session.invalidate();		
	}
	public void vc_insert(Apv_vc_dto dto,HttpSession session) {
		int mem_no = (Integer)session.getAttribute("mem_no");
		dto.setMem_no(mem_no);
		mapper.vc_insert(dto);		
		mapper.vc_insert1(dto);
		mapper.vc_insert2(dto);
		
	}
	public List<Apv_vc_dto> waitinglist(Map map) {			
		return mapper.waitinglist(map);
	}
	
	public List<Apv_vc_dto> waitinglist1(Map map) {		
		return mapper.waitinglist1(map);
	}
	public List<Apv_vc_dto> waitinglist2(Map map) {		
		return mapper.waitinglist2(map);
	}
	
	public Apv_vc_dto waitinglistdetail(int apv_no) {
		return mapper.waitinglistdetail(apv_no);
	}
	
	public void twocf(HttpSession session,int apv_no) {
		int mem_no = (Integer)session.getAttribute("mem_no");
		mapper.twocf(mem_no, apv_no);
		mapper.twocf1(mem_no, apv_no);
	}
	
	public void threecf(HttpSession session, int apv_no) {
		int mem_no = (Integer)session.getAttribute("mem_no");
		mapper.threecf(mem_no, apv_no);
		mapper.threecf1(mem_no, apv_no);
		mapper.threecf2(apv_no);
		mapper.watingdel(apv_no);
	}
	
	public List<Apv_vc_dto> cflist(Map map) {				
		return mapper.cflist(map);
	}
	
	public int cflistcount(Map map) {				
		return mapper.cflistcount(map);
	}
	
	public List<Apv_vc_dto> cflistall(Map map) {				
		return mapper.cflistall(map);
	}
	
	public int cflistallcount(Map map) {				
		return mapper.cflistallcount(map);
	}
	
	public Apv_vc_dto cfdetail(int apv_no) {
		return mapper.waitinglistdetail(apv_no);
		
	}
	
	public int watingcount(Map map) {
		return mapper.watingcount(map);
	}
	public int watingcount1(Map map) {
		return mapper.watingcount1(map);
	}
	public int watingcount2(Map map) {
		return mapper.watingcount2(map);
	}
	
	public void vc_inserttwo(Apv_vc_dto dto,HttpSession session) {
		int mem_no = (Integer)session.getAttribute("mem_no");
		dto.setMem_no(mem_no);
		mapper.vc_inserttwo(dto);
		mapper.vc_inserttwo1(dto);
		mapper.vc_inserttwo2(dto);
	}
	public void vc_insertthree(Apv_vc_dto dto,HttpSession session) {
		int mem_no = (Integer)session.getAttribute("mem_no");
		dto.setMem_no(mem_no);
		mapper.vc_insertthree(dto);
		mapper.vc_insertthree1(dto);
		
	}
	
	public void rej(Apv_vc_dto dto) {		
		mapper.rejupdate(dto);
		mapper.copyrej(dto);		
		mapper.watingdel(dto.getApv_no());
	}
	public List<Apv_vc_dto> rejlist(Map map) {		
		return mapper.rejlist(map);
	}
	
	public int rejlistcount(Map map) {		
		return mapper.rejlistcount(map);
	}
	
	public Apv_vc_dto rejdetail(int apv_no) {
		return mapper.rejdetail(apv_no);
	}
	
/////////////////////////////////////////////////////////////////////////////22-08-01/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void delrej(Apv_vc_dto dto) {
		mapper.delapv_tb(dto);
		mapper.deloriginal(dto);
		mapper.delrej(dto);		
	}
	
	public void retrypro(Apv_vc_dto dto,HttpSession session) {
		int lev = (Integer)session.getAttribute("lev");
		dto.setMem_no((Integer)session.getAttribute("mem_no"));
		if(lev==1) {
			mapper.retrypro1(dto);
			mapper.vc_rej_insert(dto);
		}else if(lev==2) {
			mapper.retrypro2(dto);
			mapper.vc_rej_inserttwo(dto);
		}
		mapper.delrej(dto);
	
	}


/////////////////////////////////////////////////////////////////////////////22-08-02/////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public List<Apv_vc_dto> watingmyapv(Map map) {
		
		return mapper.watingmyapv(map);
	}
	
	public int mywating(Map map) {
		return mapper.mywating(map);
	}
	
	public Mem_dto mydetail() {
		int a = (Integer)session.getAttribute("mem_no");
		return mapper.mydetail(a);		
	}
	
	
	//메인불러오기
	public void include(Model m) {
		Map map = new HashMap(); 
		map.put("mem_no", (Integer)session.getAttribute("mem_no"));
		if(session.getAttribute("mem_no")!=null) {
			m.addAttribute("mem_no",(Integer)session.getAttribute("mem_no"));
			m.addAttribute("lev", (Integer)session.getAttribute("lev"));
			if((Integer)session.getAttribute("lev")==1) {
				m.addAttribute("count", watingcount(map));
			}else if((Integer)session.getAttribute("lev")==2) {				
				m.addAttribute("count1", mywating(map));
				m.addAttribute("count", watingcount1(map));
			}else {
				m.addAttribute("count", watingcount2(map));
			}	
		}
	}
	

}