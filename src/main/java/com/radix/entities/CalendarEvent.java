package com.radix.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CalendarEvent 
{
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	    private int eventId;
	    private String eventName;
	    private String startDate;
	    private String endDate;
	    private String startTime;
	    private String endTime;
	    private char[]   DOW;
		public int getEventId() {
			return eventId;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
		}
		public String getEventName() {
			return eventName;
		}
		public void setEventName(String eventName) {
			this.eventName = eventName;
		}
		
		
		
		
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public char[] getDOW() {
			return DOW;
		}
		public void setDOW(char[] dOW) {
			DOW = dOW;
		}
		@Override
		public String toString() {
			return "CalendarEvent [eventId=" + eventId + ", eventName=" + eventName + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", DOW="
					+ Arrays.toString(DOW) + "]";
		}
	    
	    
	    
	    
	    
	    
	    
}
