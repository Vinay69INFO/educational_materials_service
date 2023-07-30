package com.educational.material.security;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenAuthenticationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		var token = request.getHeader("X-com-contact-auth-token");
		System.out.println("=============> " + token);
		if("beep-boop".equals(token)) {
			System.out.println("=========*if====> " + token);

			var newContext = SecurityContextHolder.createEmptyContext();
			newContext.setAuthentication(new RobotAuthentication());
			SecurityContextHolder.setContext(newContext);
			filterChain.doFilter(request, response);
		} else {
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-type", "text/plain;charset=utf-8");
			response.getWriter().println("U are not Ms Robot!");
		}
		
	}

}
