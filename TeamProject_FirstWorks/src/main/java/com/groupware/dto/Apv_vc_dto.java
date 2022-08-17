package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Apv_vc_dto {
	private int apv_no;							//문서번호
	private int mem_no;                         //현재 세션 사원번호	
	private int apv_mem_no1;					//1렙기안자 사원번호
	private int apv_mem_no2;					//2렙중간관리자 사원번호
	private int apv_mem_no3;					//3렙최종관리자 사원번호
	private int apv_cf_no;						//결재완료여부 1이 결재완료
	
	private String apv_vc_tit;                  //신청서제목					
	private String apv_vc_file;					//첨부파일
	private String apv_vc_rjt;					//반려사유
	private int apv_vc_cf_no;					//필요없는컬럼(영원한null값)
	private String apv_vc_txt;					//결재내용
	private Date apv_vc_str_dt;					//휴가시작날짜
	private Date apv_vc_end_dt;					//휴가종료날짜
	private String dept_no;						//부서번호
	private String mem_stamp_one;				//1렙기안자도장
	private String mem_stamp_two;				//2렙관리자도장
	private String mem_stamp_three;				//3렙관리자도장
	private String mem_nm;					//사원이름
	private String dept_nm;						//부서이름
	private Date regdate;							//작성시간
	private String mem_stamp;
	
	private int apv_mid_cf;						//중간관리자결재여부
	private int apv_fnl_cf;						//최종결재자결재여부
	private int apv_str_cf;						//1렙결재자 유무
	private int apv_line_one;					//1렙결재자 
	private int apv_line_two;					//2렙결재선(고정)
	private int apv_line_three;					//3렙결재선(고정)
	

	
}
