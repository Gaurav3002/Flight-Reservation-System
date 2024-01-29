//package com.flight.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.context.SecurityContextRepository;
//import org.springframework.stereotype.Service;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Service
//public class SecurityServiceImpl implements SecurityService {
//
//	@Autowired
//	UserDetailsServeceImpl userDetailsServeceImpl;
//	@Autowired
//	AuthenticationManager authenticationManager;
//	
//	@Autowired
//	SecurityContextRepository securityContextRepository;
//	@Override
//	public boolean login(String username, String password
//			,HttpServletRequest request, HttpServletResponse response) {
//		UserDetails userDetails = userDetailsServeceImpl.loadUserByUsername( username);
//		UsernamePasswordAuthenticationToken token = new
//				UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//		authenticationManager.authenticate(token);
//		boolean result = token.isAuthenticated();
//		
//		if(result) {
//			SecurityContext context = SecurityContextHolder.getContext();
//			context.setAuthentication(token);
//			securityContextRepository.saveContext(context, request, response);
//			
//		}
//		return result;
//		
//	}
//
//}
