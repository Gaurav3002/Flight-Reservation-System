 package com.flight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.model.User;
import com.flight.repository.UserRepository;
//import com.flight.service.SecurityService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
//	SecurityService securityService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
   
	@Autowired
//	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/showReg")
	public String showRegistration() {
		return"register"	;
	}
	@GetMapping("/showlog")
	public String showLogin() {
		return"login";
	}
	
	
	
	
	@PostMapping("/registerUser")
	public String Register(@ModelAttribute User user) {
		LOGGER.info("Inside register"+user);
//		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		
		return"login";
	}
//method to handle login credintial	
//	modelmap object is used to pass multiple data from controller to view dynamiclly
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelmap) {

		User user = userRepository.findByEmail(email);
		if(user != null && user.getPassword().equals(password)) {
			return "findFlight";
		}else {
			modelmap.addAttribute("msg", "Invalid user name or password. please try again");	
		}
		return "login";
		
}


//				public String login(@RequestParam("email") String email, @RequestParam("password") String password,
//						ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
//		boolean loginResponse = securityService.login(email, password,request,response);
//		LOGGER.info("Inside login() and the email is:"+email);
//		if(loginResponse) {
//			return "findFlight";
//		}
//		else {
//			modelmap.addAttribute("msg", "Invalid user name or password. please try again");
//		}
//		
//		
//		return "login";
//	}
	

}
