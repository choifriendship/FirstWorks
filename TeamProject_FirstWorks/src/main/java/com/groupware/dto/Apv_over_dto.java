package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Apv_over_dto {

	private int apv_no;
	private String mem_no;
	private String apv_over_tit;
	private String apv_over_file;
	private String apv_over_rjt;
	private int apv_over_cf_no;
	private String apv_over_txt;
	private Date apv_over_str_hrs;
	private Date apv_over_end_hrs;
	private String dept_no;
	private int apv_over_no;

}
