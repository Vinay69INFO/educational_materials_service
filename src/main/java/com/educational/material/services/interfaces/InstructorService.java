package com.educational.material.services.interfaces;

import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.LoggedInUserVO;
import com.educational.material.vo.auth.RegisterVO;

public interface InstructorService {
	public InstructorVO getById(Long instructorId);

	public LoggedInUserVO getByLoninId(Long instructorId);
	
	public void createInstructor(RegisterVO registerVO);
	
	public InstructorVO getInstructorDetailsByEmail(String emailID);

	
}
