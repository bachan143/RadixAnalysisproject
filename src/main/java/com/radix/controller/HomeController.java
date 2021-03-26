package com.radix.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.radix.entities.User;
import com.radix.helper.Message;
import com.radix.service.UserService;

@Controller
public class HomeController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title", "Home-Radix Analysis Pvt.Ltd");
		return "home";
	}
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title", "About-Radix Analysis Pvt.Ltd");
		return "about";
	}
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register-Radix Analysis Pvt.Ltd");
		model.addAttribute("user", new User());
		return "signup";
	}
	@GetMapping("/signin")
	public String customLogin(Model model) {
		model.addAttribute("title", "Login page");
		return "login";

	}
	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,
			@RequestParam(value="agreement",defaultValue = "false")boolean agreement
			,Model model,HttpSession session)
	{
		  try
		  {
			  if(!agreement)
			  {
				 
				  throw new Exception("You have not agreed the terms and conditions");
			  }
			  if(result.hasErrors())
			  {
				    System.out.println("ERROR"+result.toString());
				    model.addAttribute("user", user);
				    return "signup";
				     
			  }
			     userService.saveUserData(user);
			    
			  
			   model.addAttribute("user",new User());
			   session.setAttribute("message",
						  new Message("SuccessFully Registered","alert-success"));
			   
			   return "signup";
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  model.addAttribute("user",user);
			  session.setAttribute("message",
					  new Message("Something went Wrong"+e.getMessage(),"alert-danger"));
			  
			  return "signup";
		  }
		
	}
	
	
}