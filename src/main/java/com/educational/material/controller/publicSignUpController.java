package com.educational.material.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educational.material.transactions.interfaces.InstructorTransaction;
import com.educational.material.vo.ResponseVO;
import com.educational.material.vo.auth.RegisterVO;

@RestController
@RequestMapping("/public")
public class publicSignUpController {
	private static final Logger LOGGER = LogManager.getLogger(publicSignUpController.class);
	
	@Autowired private InstructorTransaction instructorTransaction;
 
	@PostMapping("/register")
	public ResponseVO signUp(@RequestBody RegisterVO registerVO) {
		ResponseVO responseVO = new ResponseVO();

		if (registerVO != null) {
			if (!registerVO.getEmailAddress().isEmpty() && !registerVO.getPasswordEncrypted().isEmpty()) {
				instructorTransaction.createInstructor(registerVO);
				System.out.println("Instructor record has created successfully in DB..!!"); 
				LOGGER.info("Instructor record has created successfully in DB..!!");
			} else {
				System.out.println("RegisterVO fields are empty: Email: " + registerVO.getEmailAddress() + " Password: " + registerVO.getPasswordEncrypted());
				LOGGER.debug("RegisterVO fields are empty: Email: " + registerVO.getEmailAddress() + " Password: " + registerVO.getPasswordEncrypted());
			}
		} else {
			System.out.println("RegisterVO object fields are empty!");
			LOGGER.error("RegisterVO object fields are empty...!!");
		}
		responseVO.setMes("Instructor record has created successfully in DB..!!");
		
		return responseVO;
	}
	
	
}
