package com.educational.material.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educational.material.services.interfaces.InstructorService;
import com.educational.material.transactions.interfaces.InstructorTransaction;
import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.RegisterVO;

@Component
public class InstructorTransactionImpli implements InstructorTransaction{
	
	@Autowired private InstructorService instructorService;
	
	@Override
	public void createInstructor(RegisterVO registerVO) {
		instructorService.createInstructor(registerVO);
	}

	@Override
	public InstructorVO getInstructorDetailsByEmail(String emailID) {
		return instructorService.getInstructorDetailsByEmail(emailID);
	}

}
