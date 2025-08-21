package com.educational.material.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educational.material.transactions.interfaces.InstructorSessionTransaction;
import com.educational.material.transactions.interfaces.InstructorTransaction;
import com.educational.material.utils.JwtUtil;
import com.educational.material.vo.ResponseVO;
import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.LoggedInUserVO;
import com.educational.material.vo.auth.UserVO;

@RestController
@RequestMapping("/public")
public class PublicIAMController {
	private static final Logger LOGGER = LogManager.getLogger(PublicIAMController.class);
	
	//@Autowired private CustomUserDetailsService customUserDetailsService;
	@Autowired private InstructorTransaction instructorTransaction;
	@Autowired private BCryptPasswordEncoder pwdEncoder;
	@Autowired private JwtUtil jwtUtil;
	
	@Autowired private InstructorSessionTransaction instructorSessionTransaction;

	@PostMapping("/login")
	public ResponseVO logIn(@RequestBody UserVO userVO) {
		ResponseVO responseVO = new ResponseVO();
		String logedInToken = null;
		System.out.println("================UserVO===============>" + userVO);
		InstructorVO instructorVO = instructorTransaction.getInstructorDetailsByEmail(userVO.getUsername());
		
		System.out.println(" ========== instructorVO.getEmailAddress().equals(userVO.getUsername()) ===> " + instructorVO.getEmailAddress().equals(userVO.getUsername()));
		
		System.out.println("========== pwdEncoder.matches(" + userVO.getPassword() + "," + instructorVO.getPasswordEncrypted() +") =====>  " + pwdEncoder.matches(userVO.getPassword(), instructorVO.getPasswordEncrypted()));
		
		//if(instructorVO.getEmailAddress().equals(userVO.getUsername()) && pwdEncoder.matches(userVO.getPassword(), instructorVO.getPasswordEncrypted())) {
		if(instructorVO.getEmailAddress().equals(userVO.getUsername()) && userVO.getPassword().equals(instructorVO.getPasswordEncrypted())) {
			logedInToken = jwtUtil.generateToken(userVO.getUsername());	
			System.out.println(instructorVO.getInstructorId() + "=============instructorVO ===========================> " +  instructorVO);
			InstructorSessionVO instructorSessionVO = instructorSessionTransaction.createInstructorSession(logedInToken, "D1201", instructorVO);
			LOGGER.info("Successufly completed...!!");
			responseVO.setMes("Successufly completed...!!");
		} else {
			System.out.println("Email or Password is incorrect!");
			LOGGER.debug("Email or Password is incorrect..!!");
			responseVO.setMes("Email or Password is incorrect..!");
			responseVO.setError("Email or Password is incorrect..!");
		}
		
		//responseVO.setMes("Successufly completed...!!");
		return getLogedInUserVO(responseVO,instructorVO,logedInToken);
	}
	
	private ResponseVO getLogedInUserVO(ResponseVO responseVO, InstructorVO vo, String logedInToken) {
		LoggedInUserVO loggedInUserVO = new LoggedInUserVO();
		loggedInUserVO.setEmailAddress(vo.getEmailAddress());
		loggedInUserVO.setInstructorFullName(vo.getInstructorFullName());
		loggedInUserVO.setInstructorPageKey(vo.getInstructorPageKey());
		loggedInUserVO.setLoggedInToken(logedInToken);
		responseVO.setPayload(loggedInUserVO);
		return 	responseVO;
	}
	
	private void logMessages() {
		LOGGER.trace("Login method starting execution!===== trace");
		LOGGER.debug("Login method starting execution!===== debug");
		LOGGER.info("Login method starting execution!===== info");
		LOGGER.warn("Login method starting execution!===== warn");
		LOGGER.error("Login method starting execution!===== error");
		LOGGER.fatal("Login method starting execution!===== fatal");
	}

}
