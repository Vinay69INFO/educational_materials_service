package com.educational.material.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.educational.material.services.interfaces.InstructorService;
import com.educational.material.services.interfaces.InstructorSessionServices;
import com.educational.material.vo.RequestVO;
import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.LogedInUserVO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtTokenAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired private InstructorSessionServices instructorSessionServices;
	
	@Autowired private InstructorService instructorService;
	
	@Autowired 
	@Qualifier("handlerExceptionResolver") 
	private HandlerExceptionResolver exceptionResolver;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestTokenHeader = request.getHeader("X-com-contact-auth-token");
		String requestDeviceId = request.getHeader("X-com-contact-device-id");

		try {
			if(requestTokenHeader!=null) {

				Authentication auth = authenticateRequest(requestTokenHeader, requestDeviceId);

				//TODO ---> Validate authentication - Done
				if(auth != null) {
					SecurityContextHolder.getContext().setAuthentication(auth);
					filterChain.doFilter(request, response);
				}
			} else {
				filterChain.doFilter(request, response);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private Authentication authenticateRequest(String token, String deviceId) {
		
		if (deviceId == null && token == null) {
			System.out.println("DeviceId and Token headers are not found");
		}
		
		InstructorSessionVO instructorSessionVO = instructorSessionServices.userSessionByTokenAndDevicceId(token, deviceId);
		
		if (instructorSessionVO == null) {
			System.out.println("DeviceId and Token headers are not found!");
		}
		
		if(instructorSessionVO.getStatus().equals("A")) {
			System.out.println("Session is inactive!");
		}
		
		if (this.isDateExpired(instructorSessionVO.getLogoutOrInvalidationDateTime())) {
			System.out.println("Session date got expired!");
		}
		
		//TODO---> Validate logedIn  user by DAO layer  - DONE
		LogedInUserVO userVO= instructorService.getByLoninId(instructorSessionVO.getLoginId());
		
		return createAuthenticationObject(userVO);
	}
	
	private Boolean isDateExpired(LocalDateTime logoutOrInvalidationDatetime) {
		Boolean ret = false;
		if (logoutOrInvalidationDatetime != null && logoutOrInvalidationDatetime.isBefore(LocalDateTime.now())) {
			ret = true;
			System.out.println("Date is expired!");
		} 
		
		return ret;
	}
	
	@SuppressWarnings("unused")
	private Authentication createAuthenticationObject(LogedInUserVO userVO) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		Authentication  auth = new UsernamePasswordAuthenticationToken(userVO, authorities);
	
		if(auth != null) {
			System.out.println("Authenticated...");
		} else {
			System.out.println("Authentication failed........");
		}
		return auth;
	}

}
