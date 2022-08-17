package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Mem_dto {
	private String mem_no;
	private int dept_no;
	private String mem_id;
	private String mem_pw;
	private String mem_nm;
	private String mem_eml;
	private Date mem_ent;
	private int mem_tel;
	private String mem_stamp;
	private int rank_no;
}
