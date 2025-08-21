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
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.educational.material.services.interfaces.InstructorService;
import com.educational.material.services.interfaces.InstructorSessionServices;
import com.educational.material.vo.RequestVO;
import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.LoggedInUserVO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter{

	@Autowired private InstructorSessionServices instructorSessionServices;
	@Autowired private InstructorService instructorService;
	
	public JwtTokenAuthenticationFilter(InstructorSessionServices instructorSessionServices, InstructorService instructorService) {
        this.instructorSessionServices = instructorSessionServices;
        this.instructorService = instructorService;
    }
	
	@Autowired @Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver exceptionResolver;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestTokenHeader = request.getHeader("X-com-contact-auth-token");
		String requestDeviceId = request.getHeader("X-com-contact-device-id");
		System.out.println( this.instructorSessionServices + " this X-com-contact-auth-token : doFilterInternal ====> " + requestTokenHeader);
		System.out.println(this.instructorService + " this X-com-contact-device-id : doFilterInternal =====> " + requestDeviceId);
		try {
			if(requestTokenHeader!=null) {
				System.out.println("Authentication ===================> if ");
				Authentication auth = authenticateRequest(request, requestTokenHeader);
				System.out.println(" Authentication ==== Do Filter Internal : ================> " + auth);
				//TODO ---> Validate authentication - Done
				if(auth != null) {
					SecurityContextHolder.getContext().setAuthentication(auth);
					filterChain.doFilter(request, response);
				}
			} else {
				System.out.println("Authentication ===================> else ");
				filterChain.doFilter(request, response);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private Authentication authenticateRequest(HttpServletRequest request, String token) {
		String deviceId = request.getHeader("X-com-contact-device-id");
		if (deviceId == null && token == null) {
			System.out.println("DeviceId and Token headers are not found");
		}
		System.out.println(instructorService + "X-com-contact-auth-token : " + token);
		System.out.println(instructorSessionServices + "X-com-contact-device-id : " + deviceId);
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
		LoggedInUserVO userVO = instructorService.getByLoninId(instructorSessionVO.getLoginId());
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
	
	public Authentication createAuthenticationObject(LoggedInUserVO userVO) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		if (userVO.getAuthenticationPartnerId() != null) {
			authorities.add(new SimpleGrantedAuthority("ROLE_PARTNER"));
		}
		return new UsernamePasswordAuthenticationToken(userVO, "", authorities);
	}
	

}
