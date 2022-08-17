package com.groupware.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagingDTO {
	private int startPage;//시작페이지
	private int endPage;//끝페이지
	
	private boolean prev,next; //이전,다음
	
	private int total;//총
	
	private Criteria cri;//요청한 페이지 번호,한페이지당 글개수

	
	public PagingDTO(Criteria cri,int total) {
		this.cri=cri;
		this.total=total;
		
	}
}
