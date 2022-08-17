package com.groupware.service;

import java.util.List;

import com.groupware.dto.CalendarDTO;

public interface CalendarService {
	public void add(CalendarDTO dto);

	public void modify(CalendarDTO dto);

	public void remove(int id);

	public CalendarDTO getCalendar(int id);

	public List<CalendarDTO> getList();
}
