package com.educational.material.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educational.material.services.interfaces.InstructorSessionServices;
import com.educational.material.transactions.interfaces.InstructorSessionTransaction;
import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.InstructorVO;

@Component
public class InstructorSessionTransactionImpli implements InstructorSessionTransaction{
	
    @Autowired private InstructorSessionServices sessionServices;
	
	@Override
	public InstructorSessionVO createInstructorSession(String token, String deviceId, InstructorVO instructorVO) {
		InstructorSessionVO instructorSessionVO = sessionServices.createStudentSession(token, deviceId, instructorVO);
		return instructorSessionVO;
	}

}
