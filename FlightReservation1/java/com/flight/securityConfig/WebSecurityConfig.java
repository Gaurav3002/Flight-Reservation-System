//package com.flight.securityConfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.context.DelegatingSecurityContextRepository;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
//import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
//import org.springframework.security.web.context.SecurityContextRepository;
//
//@Configuration
//public class WebSecurityConfig {
//	
//	@Autowired
//	UserDetailsService userDetailsService;
//	
//	SecurityContextRepository securityContextRepository() {
//		return new DelegatingSecurityContextRepository(new RequestAttributeSecurityContextRepository(),
//				new HttpSessionSecurityContextRepository());
//	}
//	
//	@Bean
//	AuthenticationManager authManager() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(bCryptPasswordEncoder());
//		return new ProviderManager(provider);
//	}
//	@Bean
//	BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		return http.authorizeHttpRequests(requests -> requests
//                .requestMatchers("admin/showAddFlight")
//                .hasRole("ADMIN")
//                .requestMatchers("/findFlights", "/showreservation", "/completeReservation", "completeReservation").authenticated()
//                .requestMatchers("/showReg","/registerUser", "/login", "/", "home.html","/reservation/*").permitAll())
//                .csrf(csrf -> csrf.disable()).securityContext((securityContext)->securityContext
//                		.requireExplicitSave(true)).build();
//		
//		
//	}
//
//}
