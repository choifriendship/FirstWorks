package com.groupware.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupware.dto.EmailDTO;
import com.groupware.dto.Pagedto;
import com.groupware.service.EmailService;
import com.groupware.service.GroupwareService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/email/*")
public class EmailController {
	@Setter(onMethod_ = { @Autowired })
	public EmailService service;

	@Autowired
	GroupwareService s;

	// 메일 리스트 (메인)
	@GetMapping("/MailList")
	public void MailList(Model model) {
		log.info("list");
		s.include(model);
		model.addAttribute("MailList", service.getList());
	}

	// 메일 쓰기
	@GetMapping("/write")
	public String write(HttpSession session, Model m) {

		//
		s.include(m);
		m.addAttribute("mem_eml", (String) session.getAttribute("mem_eml"));
		m.addAttribute("mem_nm", (String) session.getAttribute("mem_nm"));
		// m.addAttribute("mem_no", (String)session.getAttribute("mem_no"));
		return "email/write";

	}

	// 메일 전송 프로세스
	@PostMapping("/writepro")
	public String writepro(EmailDTO email, RedirectAttributes rttr) {
		log.info("register 메일 등록:" + email);
		service.send(email);
		rttr.addFlashAttribute("result", email.getSendermail());

		return "redirect:/email/sendList";
	}

	// 받은 메일 함
	@GetMapping("/receiveList")
	public String receivelist(Integer page, Integer pagesize, HttpSession session, Model m) {
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;
		EmailDTO dto = new EmailDTO();
		dto.setPage(page);
		dto.setPagesize(pagesize);
		dto.execute();
		dto.setReceivemail((String) session.getAttribute("mem_eml"));
		Pagedto p = new Pagedto(service.receiveListcount(dto), page, pagesize);
		m.addAttribute("ReceiveList", service.receiveList(dto));
		m.addAttribute("p", p);
		s.include(m);
		return "email/MailReceiveList";
	}

	// 보낸 메일함
	@GetMapping("/sendList")
	public String sendlist(Integer page, Integer pagesize, HttpSession session, Model m) {
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;

		EmailDTO dto = new EmailDTO();

		dto.setPage(page);
		dto.setPagesize(pagesize);
		dto.execute();
		dto.setSendermail((String) session.getAttribute("mem_eml"));

		Pagedto p = new Pagedto(service.sendListcount(dto), page, pagesize);
		m.addAttribute("SendList", service.sendList(dto));
		m.addAttribute("p", p);
		s.include(m);
		return "email/MailSendList";
	}

	// 제목 클릭시 상세페이지 이동 ,읽음 처리 업데이트
	@GetMapping("/detail")
	public String getdatail(Model m, int mailnum) {
		service.readupdate(mailnum);
		EmailDTO dto = service.detail(mailnum);// 상세보기
		m.addAttribute("data", dto);
		s.include(m);
		return "email/MailDetail";
	}

	// 보낸 메일함 디테일
	@GetMapping("/detail2")
	public String getdatail2(Model m, int mailnum) {
		EmailDTO dto = service.detail(mailnum);// 상세보기
		m.addAttribute("data", dto);
		s.include(m);
		return "email/MailDetailSend";
	}

	// 안읽은 메일함
	@GetMapping("/unreadList")
	public String unreadlist(HttpSession session, Model m) {
		EmailDTO dto = new EmailDTO();
		dto.setReceivemail((String) session.getAttribute("mem_eml"));
		m.addAttribute("Unreadlist", service.unreadlist(dto));
		m.addAttribute("Unreadcount", service.count(dto)); // 메일 수 카운트
		s.include(m);
		return "email/UnreadMailList";
	}

	// 휴지통 = 삭제한 메일
	@GetMapping("/deleteList")
	public String deletelist(HttpSession session, Model m) {
		EmailDTO dto = new EmailDTO();
		dto.setReceivemail((String) session.getAttribute("mem_eml"));
		m.addAttribute("deleteList", service.deleteview(dto));
		s.include(m);
		return "email/deleteList";
	}

	// 답장 기능
	@GetMapping("/reply")
	public String reply(HttpSession session, @RequestParam String receivemail) {
		session.setAttribute("receiveMail", receivemail);
		return "email/ReplyWrite";
	}

	// 답장 프로세스
	@PostMapping("/replypro")
	public String replypro(EmailDTO email, RedirectAttributes rttr) {
		log.info("register:" + email);

		service.reply(email);
		rttr.addFlashAttribute("result", email.getReceivemail());
		return "redirect:/email/sendList";
	}

	// 메일 삭제
	@PostMapping("/delupdate")
	public String delete(int mailnum) {
		log.info("delete 메일 삭제:");
		service.delupdate(mailnum);
		return "redirect:/email/sendList";

	}

	// 메일 전송 취소 delete
	@PostMapping("/revoke")
	public String revoke(int mailnum) {
		service.revoke(mailnum);
		return "redirect:/email/sendList";
	}

	// 메일 복구
	@PostMapping("/restore")
	public String restore(int mailnum) {
		log.info("register:" + mailnum);

		service.restore(mailnum);

		return "redirect:/email/receiveList";
	}

}
