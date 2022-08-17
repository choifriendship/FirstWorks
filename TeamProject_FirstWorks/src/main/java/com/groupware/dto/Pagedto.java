package com.groupware.dto;

import lombok.Data;

@Data
public class Pagedto {
	private int totalcnt;  //총게시물 수
	private Integer pagesize; //한페이지의 크기
	private int navisize = 10; //페이지 네비게이션의 크기
	private int totalpage; //전체페이지의 수
	private Integer page; //현재 페이지
	private int beginpage; //네비게이션의 첫번째 페이지
	private int endpage; //네비게이션의 마지막 페이지
	private boolean showprev; //이전페이지 이동하는 < 보여줄지 여부
	private boolean shownext; //다음페이지 이동하는 > 보여줄지 여부	
	private String key;						//검색키
	private String word;					//검색단어
	
	
	public Pagedto(int totalcnt,int page) {
		this(totalcnt,page,10);
	}
	
	public  Pagedto(int totalcnt,int page,int pagesize) {
		this.totalcnt = totalcnt;
		this.page = page;
		this.pagesize = pagesize;
		
		totalpage = (int)Math.ceil((double)totalcnt / (double)pagesize);
		beginpage = (page-1) / navisize * navisize+1;
		endpage = Math.min(beginpage + navisize-1,totalpage);
		showprev = (beginpage != 1);
		shownext = (endpage != totalpage);		
	}
	
	void print() {
		System.out.println("page="+page);
		System.out.println(showprev ? "[PREV]" : "");
		for(int i = beginpage;i<endpage;i++) {
			System.out.println(i+" ");
		}
		System.out.println(shownext ? "[NEXT]" : "");
	}
	
	
	
	
	
}
