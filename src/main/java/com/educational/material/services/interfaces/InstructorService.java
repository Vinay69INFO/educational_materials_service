package com.educational.material.services.interfaces;

import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.LogedInUserVO;

public interface InstructorService {
	InstructorVO getById(Long instructorId);

	LogedInUserVO getByLoninId(Long instructorId);
	
}
