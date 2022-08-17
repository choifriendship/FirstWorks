package com.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.groupware.dto.CalendarDTO;
import com.groupware.mapper.CalendarMapper;

@Repository
@Service
public class CalendarServiceImpl implements CalendarService {
	@Autowired
	private CalendarMapper mapper;

	@Override
	public void add(CalendarDTO dto) {
		mapper.insert(dto);
	}

	@Override
	public void modify(CalendarDTO dto) {
		mapper.update(dto);
	}

	@Override
	public void remove(int id) {
		mapper.delete(id);
	}

	@Override
	public CalendarDTO getCalendar(int id) {
		return mapper.select(id);
	}

	@Override
	public List<CalendarDTO> getList() {
		return mapper.getList();
	}
}
