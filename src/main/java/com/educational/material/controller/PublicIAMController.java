package com.educational.material.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educational.material.utils.JwtUtil;
import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.UserVO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/public")
public class PublicIAMController {
	
	private static final Logger LOGGER = LogManager.getLogger(PublicIAMController.class);
	
	//@Autowired private CustomUserDetailsService customUserDetailsService;
	@Autowired private BCryptPasswordEncoder pwdEncoder;
	@Autowired private JwtUtil jwtUtil;

	@GetMapping("/login")
	public String logIn(@RequestBody UserVO userVO) {
		LOGGER.trace("Login method starting execution!===== trace");
		LOGGER.debug("Login method starting execution!===== debug");
		LOGGER.info("Login method starting execution!===== info");
		LOGGER.warn("Login method starting execution!===== warn");
		LOGGER.error("Login method starting execution!===== error");
		LOGGER.fatal("Login method starting execution!===== fatal");

		String token = null;
		InstructorVO vo = new InstructorVO();
		vo.setEmailAddress("email.com");
		vo.setPasswordEncrypted("pwd_password");
		
		/*Base64.Decoder decoder = Base64.getDecoder();	
		String userPass = new String(decoder.decode(userVO.getPassword()));
		
		if(vo.getEmailAddress().equals(userVO.getUsername()) && pwdEncoder.matches(userVO.getPassword(), vo.getPasswordEncrypted())) {
			token = jwtUtil.generateToken(userVO.getUsername());
			
			// TODO -- Create session record
		} else {
			System.out.println("Email or Password is incorrect!");
		}*/
		return "Successufly completed";
	}

}
