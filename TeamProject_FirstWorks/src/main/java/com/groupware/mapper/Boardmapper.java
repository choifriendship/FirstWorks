package com.groupware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Mem_dto;
import com.groupware.dto.MemberDTO;
import com.groupware.dto.Pagedto;






public interface Boardmapper {
	//@Select("select * from mem_tb")
	public List<Mem_dto> test();


//	휴가신청서 입력하기
//	@Insert("insert all "
//			+ "into apv_vc_tb values ('1',#{apv_vc_tit, jdbcType=VARCHAR},#{apv_vc_file, jdbcType=VARCHAR},#{apv_vc_rjt, jdbcType=VARCHAR},#{apv_vc_cf_no, jdbcType=INTEGER},#{apv_vc_txt, jdbcType=VARCHAR},#{apv_vc_str_dt},#{apv_vc_end_dt},#{dept_no, jdbcType=VARCHAR},inc_seq.NEXTVAL)"
//			+ "into apv_tb (apv_no,mem_no,apv_vc_no) values (inc_seq.NEXTVAL,'1',inc_seq.NEXTVAL) "
//			+ "select * from dual")
//	public void apv_vc_insert(Apv_vc_dto board);
	
	

////	휴가신청서 불러오기(사원번호) -> 대기문서
//	@Select("select * from apv_vc_tb where mem_no=#{mem_no}")
//	public List<Apv_vc_dto> apv_vc_list(Apv_vc_dto board);
//
////	휴가신청서 불러오기(문서번호) -> 대기문서를 클릭하면 들어가지는 곳
//	@Select("select * from apv_vc_tb where apv_vc_no=#{apv_vc_no}")
//	public Apv_vc_dto apv_vc_detail(Apv_vc_dto board);
//
//// 시간외근무 신청서 입력하기
//	@Insert("insert into apv_over_tb values"
//			+ "(#{apv_no, jdbcType=INTEGER}, #{mem_no, jdbcType=VARCHAR}, #{apv_over_tit, jdbcType=VARCHAR}, #{apv_over_file, jdbcType=VARCHAR}, #{apv_over_rjt, jdbcType=VARCHAR}, #{apv_over_cf_no, jdbcType=INTEGER}, #{apv_over_txt, jdbcType=VARCHAR}, #{apv_over_str_hrs}, #{apv_over_end_hrs}, #{dept_no, jdbcType=VARCHAR} ")
//	public void apv_over_insert(Apv_over_dto board);
//
////	시간외근무 신청서 불러오기(사원번호) -> 대기문서
//	@Select("select * from apv_over_tb where mem_no=#{mem_no}")
//	public List<Apv_over_dto> apv_over_list(Apv_over_dto board);
//
////	시간외근무 신청서 불러오기(문서번호) -> 대기문서를 클릭하면 들어가지는 곳
//	@Select("select * from apv_over_tb where apv_no=#{apv_no}")
//	public Apv_over_dto apv_over_detail(Apv_over_dto board);

//	도장업로드
	@Update("update mem_tb set mem_stamp=#{filename} where mem_no=#{mem_no}")
	public void stampupload(@Param("filename")String filename,@Param("mem_no")int mem_no);

//  도장가져오기
	@Select("select mem_stamp from mem_tb where mem_no=#{mem_no}")
	public Apv_vc_dto getstamp(Apv_vc_dto board);
	
	//로그인 -> 레벨가져오기
	@Select("select rank_no from mem_tb where mem_no=#{mem_no}")
	public int getrank(int mem_no);
		
	//1레벨 휴가결재 (XML사용)
//	@Insert("insert into apv_tb values (null,#{mem_no},2,3,0)")
//	@Options(useGeneratedKeys = true, keyProperty = "apv_no")
	public int vc_insert(Apv_vc_dto dto);
	
	@Insert("insert into apv_vc_tb values (#{mem_no},#{apv_vc_tit},#{apv_vc_file},#{apv_vc_rjt},#{apv_vc_cf_no},#{apv_vc_txt},#{apv_vc_str_dt},#{apv_vc_end_dt},#{dept_no},#{apv_no}, (select mem_stamp from mem_tb where mem_no=#{mem_no}),#{mem_stamp_two},#{mem_stamp_three},(select mem_nm from mem_tb where mem_no=#{mem_no}),#{dept_nm},sysdate)")
	public void vc_insert1(Apv_vc_dto dto);
	
	@Insert("insert into apv_wait_tb values (#{apv_no},0,0,#{mem_no},#{mem_no},2,3)")
	public void vc_insert2(Apv_vc_dto dto);
	
//	@Select("select * from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_line_one=#{mem_no} order by apv_vc_tb.apv_no desc")
//	public List<Apv_vc_dto> waitinglist(int mem_no);
	
	//검색기능추가를위해 xml로 옴김 ㅜㅜ
	//@Select("select * from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_line_one=#{mem_no} order by apv_vc_tb.apv_no desc limit #{offset},#{pagesize}")
	public List<Apv_vc_dto> waitinglist(Map map);
	
	//검색기능추가를위해 xml로 옴김 ㅜㅜ
	//@Select("select * from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_line_two=#{mem_no} and apv_wait_tb.apv_mid_cf=0 order by apv_vc_tb.apv_no desc limit #{offset},#{pagesize}")	
	public List<Apv_vc_dto> waitinglist1(Map map);
	
	//검색기능추가를위해 xml로 옴김 ㅜㅜ
	//@Select("select * from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_line_three=#{mem_no} order by apv_vc_tb.apv_no desc limit #{offset},#{pagesize}")
	public List<Apv_vc_dto> waitinglist2(Map map);
	
	@Select("select * from apv_vc_tb where apv_no=#{apv_no}")
	public Apv_vc_dto waitinglistdetail(int apv_no);
	
	@Update("update apv_wait_tb set apv_mid_cf=#{mem_no} where apv_no=#{apv_no}")
	public void twocf(@Param("mem_no")int mem_no,@Param("apv_no")int apv_no);
	
	@Update("update apv_vc_tb set mem_stamp_two = (select mem_stamp from mem_tb where mem_no=#{mem_no}) where apv_no=#{apv_no}")
	public void twocf1(@Param("mem_no")int mem_no,@Param("apv_no")int apv_no);
	
	///////////////////////8월4일////////////////////////
	
	@Update("update apv_wait_tb set apv_fnl_cf=#{mem_no} where apv_no=#{apv_no}")
	public void threecf(@Param("mem_no")int mem_no,@Param("apv_no")int apv_no);
	
	@Update("update apv_vc_tb set mem_stamp_three = (select mem_stamp from mem_tb where mem_no=#{mem_no}) where apv_no=#{apv_no}")
	public void threecf1(@Param("mem_no")int three_no,@Param("apv_no")int apv_no);
	
	@Update("update apv_tb set apv_cf_no=1 where apv_no=#{apv_no}")
	public void threecf2(int apv_no);
	
	@Delete("delete from apv_wait_tb where apv_no=#{apv_no}")
	public void watingdel(int apv_no);
	
	//검색기능추가를위해 xml로 옴김 ㅜㅜ
	//@Select("select * from apv_tb,apv_vc_tb where apv_tb.apv_no=apv_vc_tb.apv_no and apv_tb.apv_cf_no=1 "
	//		+ "and (apv_tb.apv_mem_no1=#{mem_no} or apv_tb.apv_mem_no2=#{mem_no} or apv_tb.apv_mem_no3=#{mem_no}) order by apv_vc_tb.apv_no desc limit #{offset},#{pagesize}")
	public List<Apv_vc_dto> cflist(Map map);
	
	//검색기능추가를위해 xml로 옴김 ㅜㅜ
//	@Select("select count(*) from apv_tb,apv_vc_tb where apv_tb.apv_no=apv_vc_tb.apv_no and apv_tb.apv_cf_no=1 "
//			+ "and (apv_tb.apv_mem_no1=#{mem_no} or apv_tb.apv_mem_no2=#{mem_no} or apv_tb.apv_mem_no3=#{mem_no})")
	public int cflistcount(Map map);
	
	//검색기능추가를위해 xml로 옴김 ㅜㅜ
	//@Select("select * from apv_tb,apv_vc_tb where apv_tb.apv_no=apv_vc_tb.apv_no and apv_tb.apv_cf_no=1 order by apv_vc_tb.apv_no desc limit #{offset},#{pagesize}")
	public List<Apv_vc_dto> cflistall(Map map);
	
	//검색기능추가를위해 xml로 옴김 ㅜㅜ
	//@Select("select count(*) from apv_tb where apv_tb.apv_cf_no=1")
	public int cflistallcount(Map map);
	
	//검색처리를위해 xml로 이사 ㅜㅜ
	//@Select("select count(apv_wait_tb.apv_no) from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_str_cf=#{mem_no}")
	public int watingcount(Map map);
	
	//검색처리를위해 xml로 이사 ㅜㅜ
	//@Select("select count(apv_wait_tb.apv_no) from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_mid_cf=0 and apv_wait_tb.apv_line_two=#{mem_no}")
	public int watingcount1(Map map);
	
	//검색처리를위해 xml로 이사 ㅜㅜ
	//@Select("select count(apv_wait_tb.apv_no) from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_fnl_cf=0 and apv_wait_tb.apv_mid_cf!=0 and apv_wait_tb.apv_line_three=#{mem_no}")
	public int watingcount2(Map map);
	
	//inserttwo	
//	@Insert("insert into apv_tb values (null,0,#{mem_no},3,0)")
//	@Options(useGeneratedKeys = true, keyProperty = "apv_no")
	public void vc_inserttwo(Apv_vc_dto dto);	
	
	@Insert("insert into apv_vc_tb values (#{mem_no},#{apv_vc_tit},#{apv_vc_file},#{apv_vc_rjt},#{apv_vc_cf_no},#{apv_vc_txt},#{apv_vc_str_dt},#{apv_vc_end_dt},#{dept_no},#{apv_no}, #{mem_stamp_one},(select mem_stamp from mem_tb where mem_no=#{mem_no}),#{mem_stamp_three},(select mem_nm from mem_tb where mem_no=#{mem_no}),#{dept_nm},sysdate)")
	public void vc_inserttwo1(Apv_vc_dto dto);
	
	@Insert("insert into apv_wait_tb values (#{apv_no},#{mem_no},0,0,0,#{mem_no},3)")
	public void vc_inserttwo2(Apv_vc_dto dto);
	
	//insertthree
//	@Insert("insert into apv_tb values (null,0,0,#{mem_no},1)")
//	@Options(useGeneratedKeys = true, keyProperty = "apv_no")
	public void vc_insertthree(Apv_vc_dto dto);
	
	
	//@Insert("insert into apv_vc_tb values (#{apv_no},#{text},#{one_stamp},#{one_stamp},(select mem_stamp from mem where mem_no=#{one_no}),#{rej})")
	@Insert("insert into apv_vc_tb values (#{mem_no},#{apv_vc_tit},#{apv_vc_file},#{apv_vc_rjt},#{apv_vc_cf_no},#{apv_vc_txt},#{apv_vc_str_dt},#{apv_vc_end_dt},#{dept_no},#{apv_no}, #{mem_stamp_one},#{mem_stamp_two}, (select mem_stamp from mem_tb where mem_no=#{mem_no},(select mem_nm from mem_tb where mem_no=#{mem_no}),#{dept_nm},sysdate)")
	public void vc_insertthree1(Apv_vc_dto dto);
	
	@Update("update apv_vc_tb set apv_vc_rjt=#{apv_vc_rjt} where apv_no=#{apv_no}")
	public void rejupdate(Apv_vc_dto dto);
	
	@Insert("INSERT INTO apv_rjt_tb SELECT * FROM apv_vc_tb WHERE apv_no=#{apv_no}")
	public void copyrej(Apv_vc_dto dto);
	
	@Delete("delete from apv_vc_tb where apv_no=#{apv_no}")
	public void deloriginal(Apv_vc_dto dto);

	//검색처리를위해 xml로 이사 ㅜㅜ
	//@Select("select * from apv_tb,apv_rjt_tb where apv_tb.apv_no=apv_rjt_tb.apv_no and (apv_tb.apv_mem_no1=#{mem_no} or apv_tb.apv_mem_no2=#{mem_no} or apv_tb.apv_mem_no3=#{mem_no}) order by apv_rjt_tb.apv_no desc limit #{offset},#{pagesize}")
	public List<Apv_vc_dto> rejlist(Map map);
	
	//검색처리를위해 xml로 이사 ㅜㅜ
	//@Select("select count(*) from apv_tb,apv_rjt_tb where apv_tb.apv_no=apv_rjt_tb.apv_no and (apv_tb.apv_mem_no1=#{mem_no} or apv_tb.apv_mem_no2=#{mem_no} or apv_tb.apv_mem_no3=#{mem_no})")
	public int rejlistcount(Map map);
	
	@Select("select * from apv_rjt_tb where apv_no=#{apv_no}")
	public Apv_vc_dto rejdetail(int apv_no);	
	
/////////////////////////////////////////////////////////////////////////////22-08-01/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Delete("delete from apv_tb where apv_no=#{apv_no}")
	public void delapv_tb(Apv_vc_dto dto);
	
	@Delete("delete from apv_rjt_tb where apv_no=#{apv_no}")
	public void delrej(Apv_vc_dto dto);
	
	//1렙 재결재
	@Update("update apv_vc_tb set apv_vc_txt=#{apv_vc_txt}, mem_stamp_two=#{mem_stamp_three} where apv_no=#{apv_no}") //재결재시 모든도장 초기화시킴(null값으로된 아무변수나 넣어도됨)
	public void retrypro1(Apv_vc_dto dto);	
	
	@Update("update apv_vc_tb set apv_vc_txt=#{apv_vc_txt} where apv_no=#{apv_no}")//2렙 재결재
	public void retrypro2(Apv_vc_dto dto);
	
	@Insert("insert into apv_wait_tb values (#{apv_no},0,0,#{mem_no},#{mem_no},2,3)")
	public void vc_rej_insert(Apv_vc_dto dto);
	
	@Insert("insert into apv_wait_tb values (#{apv_no},#{mem_no},0,0,0,#{mem_no},3)")
	public void vc_rej_inserttwo(Apv_vc_dto dto);
	
/////////////////////////////////////////////////////////////////////////////22-08-02/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//검색처리를위해 xml로 이사 ㅜㅜ
	//@Select("select * from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_str_cf=0 and apv_wait_tb.apv_mid_cf=#{mem_no} order by apv_wait_tb.apv_no desc limit #{offset},#{pagesize}")
	public List<Apv_vc_dto> watingmyapv(Map map);
	
	//검색처리를위해 xml로 이사 ㅜㅜ
	//@Select("select count(*) from apv_vc_tb,apv_wait_tb where apv_vc_tb.apv_no=apv_wait_tb.apv_no and apv_wait_tb.apv_str_cf=0 and apv_wait_tb.apv_mid_cf=#{mem_no}")
	public int mywating(Map map);
	
	@Select("select * from mem_tb where mem_no=#{mem_no}")
	public Mem_dto mydetail(int mem_no);
	
	
	
}
	
	
	
	
	
	
	
