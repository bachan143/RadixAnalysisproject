package com.radix.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.radix.entities.CalendarEvent;
import com.radix.entities.User;
import com.radix.helper.Message;
import com.radix.repository.UserRepository;
import com.radix.service.CalendarEventService;
import com.radix.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	@Autowired
	private CalendarEventService calendarEventService;
	//Home dashBoard
	@ModelAttribute
	public void addCommonData(Model model,Principal principal)
	{
		String name = principal.getName();
		User user= userService.getUserDetails(name);
		 
		model.addAttribute("user",user);
		
	}
	
	
	@RequestMapping("/index")
	public String dashboard(Model model)
	{
		
		   
		model.addAttribute("title","User DashBoard");
		
		
		return "normal/user_dashboard";
	}
	//open add form handler
	@RequestMapping("/add-event")
	 public String openAddEventCalender(Model model)
	 {
		
		   
		
		
		 
		
		 model.addAttribute("title","Add EventCalendar");
		 model.addAttribute("event", new CalendarEvent());
		 return "normal/add_event_calendar_form";
	 }
	 //processing add eventCalendar
	@PostMapping("/process-event")
	  public String saveEventCalendar(@ModelAttribute CalendarEvent event,HttpSession session )
	  {
		     try
		     {
		    	   calendarEventService.saveEventCalendarData(event);
		    	   
		    	 session.setAttribute("message", new Message("You event is Addedd!! Add More","success"));
		     }catch(Exception e)
		     {
		    	 e.printStackTrace();
		    	 session.setAttribute("message", new Message("Some Went Wrong!! Try Again","danger"));
		    	 
		     }
		     
		     
		     
		    return "normal/add_event_calendar_form";
	  }
	
	  //show Event hadndler
	@GetMapping("/show-events")
	  public String showEvents(Model model)
	  {
		   model.addAttribute("title","Show User Events");
		      List<CalendarEvent> eventsData = this.calendarEventService.findAllData();
		         model.addAttribute("events", eventsData);
		   return "normal/show_events";
		  
	  }
	
	      //Delete Contact Handler
	   @GetMapping("/delete/{eventId}")
	    public String deleteContact(@PathVariable("eventId") Integer eventId,Model model,HttpSession session)
	    {
		       Optional<CalendarEvent> findById = calendarEventService.findById(eventId);
		            CalendarEvent event=findById.get();
		                this.calendarEventService.delete(event);
		                session.setAttribute("message", new Message("Event Deleted Successfully","success"));
		       
	    	 return "redirect:/user/show-events";
	    }
	
	

}
