package com.educational.material.transactions.interfaces;

import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.InstructorVO;

public interface InstructorSessionTransaction {
	InstructorSessionVO createInstructorSession(String token, String deviceId, InstructorVO instructorVO);
}
