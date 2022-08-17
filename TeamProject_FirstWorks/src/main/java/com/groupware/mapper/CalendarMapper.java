package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.CalendarDTO;


public interface CalendarMapper {
	public int insert(CalendarDTO dto);
	public int update(CalendarDTO dto);
	public int delete(int id);
	public CalendarDTO select(int id);
	public List<CalendarDTO> getList();
}
