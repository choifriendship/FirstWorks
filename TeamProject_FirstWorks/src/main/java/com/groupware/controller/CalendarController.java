package com.groupware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.groupware.dto.CalendarDTO;
import com.groupware.service.CalendarService;

@Component
@Controller
public class CalendarController {
	@Autowired
	private CalendarService service;

	// Ķ���� �� �����ִ� �޼ҵ�
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar() {
		return "calendar/calendar";
	}

	// ����
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	@ResponseBody
	public CalendarDTO calendar(@RequestParam int id) throws Exception {
		return service.getCalendar(id);
	}

	// ���� ���
	@RequestMapping(value = "/calendarList", method = RequestMethod.GET)
	@ResponseBody
	public List<CalendarDTO> calendarList() throws Exception {
		return service.getList();
	}

	// ���� �߰� �޼ҵ�
	@RequestMapping(value = "/calendarInsert", method = RequestMethod.POST)
	@ResponseBody
	public String calendarInsert(CalendarDTO dto) throws Exception {
		dto.setTitle(HtmlUtils.htmlEscape(dto.getTitle()));
		dto.setTxt(HtmlUtils.htmlEscape(dto.getTxt()));
		service.add(dto);
		return "success";
	}

	// ���� ����
	@RequestMapping(value = "/calendarUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String calendarUpdate(CalendarDTO dto) throws Exception {
		dto.setTitle(HtmlUtils.htmlEscape(dto.getTitle()));
		dto.setTxt(HtmlUtils.htmlEscape(dto.getTxt()));
		service.modify(dto);
		return "success";
	}

	// ���� ����
	@RequestMapping(value = "/calendarRemove")
	@ResponseBody
	public String calendarRemove(@RequestParam int id) throws Exception {
		System.out.println(id);
		service.remove(id);
		return "calendar/calendar";
	}
}