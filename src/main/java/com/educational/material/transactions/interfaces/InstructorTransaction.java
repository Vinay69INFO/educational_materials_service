package com.educational.material.transactions.interfaces;

import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.RegisterVO;

public interface InstructorTransaction {
	void createInstructor(RegisterVO registerVO);
	
	InstructorVO getInstructorDetailsByEmail(String emailID);

}
