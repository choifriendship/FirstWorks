package com.groupware.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Pagedto;
import com.groupware.service.GroupwareService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class GroupwareController {
	@Autowired
	GroupwareService service;

	@Autowired
	HttpSession session;

	@InitBinder
	public void initbinder(WebDataBinder binder) {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(d, false));
	}

	@GetMapping("/")
	public String index(Model m, HttpSession session) {
		Map map = new HashMap();
		map.put("mem_no", (Integer) session.getAttribute("mem_no"));
		if (session.getAttribute("mem_no") != null) {
			m.addAttribute("mem_no", (Integer) session.getAttribute("mem_no"));
			m.addAttribute("lev", (Integer) session.getAttribute("lev"));
			if ((Integer) session.getAttribute("lev") == 1) {
				m.addAttribute("count", service.watingcount(map));
			} else if ((Integer) session.getAttribute("lev") == 2) {
				m.addAttribute("count1", service.mywating(map));
				m.addAttribute("count", service.watingcount1(map));
			} else {
				m.addAttribute("count", service.watingcount2(map));
			}
		}
		return "redirect:login/Login_form";
	}

//	@GetMapping("/login")
//	public String login() {
//		return "loginform";
//	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		service.logout(session);
		return "redirect:/";
	}

	@PostMapping("/loginpro")
	public String loginpro(int mem_no, HttpSession session) {
		service.login(mem_no, session);
		return "redirect:/main";
	}

	@GetMapping("/vcform")
	public String vcform(HttpSession session, Model m) {
		include(m);
		m.addAttribute("lev", (Integer) session.getAttribute("lev"));
		return "Apv_vc_form";
	}

	@PostMapping("/vcpro")
	public String vcpro(Apv_vc_dto dto, HttpSession session) {
		service.vc_insert(dto, session);
		return "redirect:/main";
	}

	@PostMapping("/vcprotwo")
	public String vcprotwo(Apv_vc_dto dto, HttpSession session) {
		service.vc_inserttwo(dto, session);
		return "redirect:/";
	}

	@PostMapping("/vcprothree")
	public String vcprothree(Apv_vc_dto dto, HttpSession session) {
		service.vc_insertthree(dto, session);
		return "redirect:/main";
	}

	@GetMapping("/watinglist")
	public String watinglist(Integer page, Integer pagesize, String key, String word, HttpSession session, Model m) {
		include(m);
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;
		int totalcnt;
		Map map = new HashMap();
		map.put("mem_no", (Integer) session.getAttribute("mem_no"));
		map.put("offset", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		map.put("key", key);
		map.put("word", word);
		if ((Integer) session.getAttribute("lev") == 1) {
			totalcnt = service.watingcount(map);
		} else if ((Integer) session.getAttribute("lev") == 2) {
			totalcnt = service.watingcount1(map);
		} else {
			totalcnt = service.watingcount2(map);
		}
		Pagedto p = new Pagedto(totalcnt, page, pagesize);
		p.setKey(key);
		p.setWord(word);
		if ((Integer) session.getAttribute("lev") == 1) {
			m.addAttribute("p", p);
			m.addAttribute("list", service.waitinglist(map));
			m.addAttribute("lev", (Integer) session.getAttribute("lev"));
		} else if ((Integer) session.getAttribute("lev") == 2) {
			m.addAttribute("p", p);
			m.addAttribute("list", service.waitinglist1(map));
			m.addAttribute("lev", (Integer) session.getAttribute("lev"));
		} else {
			m.addAttribute("p", p);
			m.addAttribute("list", service.waitinglist2(map));
			m.addAttribute("lev", (Integer) session.getAttribute("lev"));
		}
		return "watinglist";
	}

	@GetMapping("/waitinglistdetail")
	public String waitinglistdetail(int apv_no, Model m, HttpSession session) {
		include(m);
		m.addAttribute("lev", (Integer) session.getAttribute("lev"));
		m.addAttribute("mem_no", (Integer) session.getAttribute("mem_no"));
		m.addAttribute("list", service.waitinglistdetail(apv_no));
		return "Apv_vc_detail";
	}

	@PostMapping("/twocf")
	public String twocf(HttpSession session, int apv_no) {
		service.twocf(session, apv_no);
		return "redirect:/watinglist";
	}

	@PostMapping("/threecf")
	public String threecf(HttpSession session, int apv_no) {
		service.threecf(session, apv_no);
		return "redirect:/watinglist";
	}

	@GetMapping("/cflist")
	public String cflist(Integer page, Integer pagesize, String key, String word, HttpSession session, Model m) {
		include(m);
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;
		Map map = new HashMap();
		map.put("offset", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		map.put("mem_no", (Integer) session.getAttribute("mem_no"));
		map.put("key", key);
		map.put("word", word);
		Pagedto p = new Pagedto(service.cflistcount(map), page, pagesize);
		p.setKey(key);
		p.setWord(word);
		m.addAttribute("p", p);
		m.addAttribute("list", service.cflist(map));
		return "cflist";
	}

	@GetMapping("/cflistall")
	public String cflistall(Integer page, Integer pagesize, String key, String word, HttpSession session, Model m) {
		include(m);
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;
		Map map = new HashMap();
		map.put("offset", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		map.put("key", key);
		map.put("word", word);
		Pagedto p = new Pagedto(service.cflistallcount(map), page, pagesize);
		p.setKey(key);
		p.setWord(word);
		m.addAttribute("p", p);
		m.addAttribute("list", service.cflistall(map));
		return "cflistall";
	}

	@GetMapping("/cfdetail")
	public String cfdetail(int apv_no, Model m) {
		include(m);
		m.addAttribute("list", service.cfdetail(apv_no));
		return "apv_vc_cfdetail";
	}

	@GetMapping("/rej")
	public String rej(Apv_vc_dto dto) {
		service.rej(dto);
		return "redirect:/watinglist";
	}

	@GetMapping("/rejlist")
	public String rejlist(Integer page, Integer pagesize, String key, String word, HttpSession session, Model m) {
		include(m);
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;
		Map map = new HashMap();
		map.put("offset", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		map.put("mem_no", (Integer) session.getAttribute("mem_no"));
		map.put("key", key);
		map.put("word", word);
		Pagedto p = new Pagedto(service.rejlistcount(map), page, pagesize);
		p.setKey(key);
		p.setWord(word);
		m.addAttribute("p", p);
		m.addAttribute("list", service.rejlist(map));
		return "rejlist";
	}

	@GetMapping("/rejdetail")
	public String rejdetail(int apv_no, Model m) {
		include(m);
		m.addAttribute("list", service.rejdetail(apv_no));
		return "/apv_rej_detail";
	}

	@GetMapping("/stampform")
	public void stampform() {
	}

	@PostMapping("/stampupload")
	public String stampupload(MultipartFile[] uploadFile, HttpSession session) {
		service.stampupload(uploadFile, session);
		return "redirect:/main";
	}

/////////////////////////////////////////////////////////////////////////////22-08-01/////////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/delrej")
	public String delrej(Apv_vc_dto dto) {
		service.delrej(dto);
		return "/rejlist";
	}

	@PostMapping("/retry")
	public String retry(Apv_vc_dto dto, Model m) {
		include(m);
		m.addAttribute("list", dto);
		return "Apv_vc_retry";
	}

	@PostMapping("/retrypro")
	public String retrypro(Apv_vc_dto dto, HttpSession session) {
		service.retrypro(dto, session);
		return "redirect:/rejlist";
	}

	///////////////////////////////////////////////////////////////////////////// 22-08-02/////////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/watingmyapv")
	public String watingmyapv(Integer page, Integer pagesize, String key, String word, Model m) {
		include(m);
		if (page == null)
			page = 1;
		if (pagesize == null)
			pagesize = 10;
		Map map = new HashMap();
		map.put("mem_no", (Integer) session.getAttribute("mem_no"));
		map.put("key", key);
		map.put("word", word);
		map.put("offset", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		Pagedto p = new Pagedto(service.mywating(map), page, pagesize);
		p.setKey(key);
		p.setWord(word);
		m.addAttribute("p", p);
		m.addAttribute("list", service.watingmyapv(map));
		return "/watingmyapvlist";
	}

	///////////////////////////////////////////////////////////////////////////// 22-08-02/////////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/main")
	public void main(Model m) {
		include(m);
	}

	@GetMapping("/mydetail")
	public String mydetail(Model m) {
		m.addAttribute("list", service.mydetail());
		return "/login/mydetail";
	}

	// 중요 띄우기
	private void include(Model m) {
		Map map = new HashMap();
		map.put("mem_no", (Integer) session.getAttribute("mem_no"));
		if (session.getAttribute("mem_no") != null) {
			m.addAttribute("mem_no", (Integer) session.getAttribute("mem_no"));
			m.addAttribute("lev", (Integer) session.getAttribute("lev"));
			if ((Integer) session.getAttribute("lev") == 1) {
				m.addAttribute("count", service.watingcount(map));
			} else if ((Integer) session.getAttribute("lev") == 2) {
				m.addAttribute("count1", service.mywating(map));
				m.addAttribute("count", service.watingcount1(map));
			} else {
				m.addAttribute("count", service.watingcount2(map));
			}
		}
	}
}
