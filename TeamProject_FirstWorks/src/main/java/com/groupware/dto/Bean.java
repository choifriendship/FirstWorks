package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Bean {
	private EmailDTO email;
	private MemberDTO member;
	
	
	private String receivemail;
	private String title;
	private Date registerdate;
	
	
	
}
