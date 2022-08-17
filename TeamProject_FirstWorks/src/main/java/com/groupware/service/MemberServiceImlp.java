package com.groupware.service;



import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupware.dto.MemberDTO;
import com.groupware.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

//����
@Log4j
@Service
public class MemberServiceImlp implements MemberService {
	
	@Autowired
	private MemberMapper mapper;	
	
	@Autowired
	private HttpSession session;
	
	

	//�α��� member -> ���� �Է�  / dto->db���� ������
	@Override
	public int login(MemberDTO member) throws Exception {
		MemberDTO dto =  mapper.memdetail(member);
		if(mapper.login(member)==1) {
			System.out.println(dto);
			session.setAttribute("mem_id", dto.getMem_id());			
			session.setAttribute("mem_nm", dto.getMem_nm());
			session.setAttribute("mem_eml", dto.getMem_eml());
			session.setAttribute("mem_no", (dto.getMem_no()));//������ ����ȯ
			session.setAttribute("lev", dto.getRank_no());
			return 1; 
		}else {
			return 0; 
		}
		
		
	}
	//ȸ������
	@Override
	public void register(MemberDTO member) {
		// TODO Auto-generated method stub
	}
	//ȸ�� ����
	@Override
	public boolean memberdelete(String mem_no) {
		// TODO Auto-generated method stub
		return false;
	}
	//��������
	@Override
	public boolean memberupdate(MemberDTO member) {
		// TODO Auto-generated method stub
		return false;
	}

}
