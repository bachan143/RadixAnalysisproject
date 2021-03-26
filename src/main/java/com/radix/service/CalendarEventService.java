package com.radix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radix.entities.CalendarEvent;
import com.radix.repository.CalendarEventRepository;

@Service
public class CalendarEventService {

	
	@Autowired
	 CalendarEventRepository calendarEventRepository;
	public void saveEventCalendarData(CalendarEvent event) {
		// TODO Auto-generated method stub
		
		calendarEventRepository.save(event);
		
		
	}
	public List<CalendarEvent> findAllData() {
		// TODO Auto-generated method stub
		
		
		        return calendarEventRepository.findAll();
		
	}
	public Optional<CalendarEvent>  findById(Integer eventId) {
		// TODO Auto-generated method stub
		    return calendarEventRepository.findById(eventId);
	}
	public void delete(CalendarEvent event) {
		// TODO Auto-generated method stub
		   calendarEventRepository.delete(event);
		
	}
	
	

}
