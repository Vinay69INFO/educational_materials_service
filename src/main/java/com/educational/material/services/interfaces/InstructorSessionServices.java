package com.educational.material.services.interfaces;

import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.InstructorVO;

public interface InstructorSessionServices {

	public InstructorSessionVO userSessionByTokenAndDevicceId(String token, String deviceId);

	public InstructorSessionVO createStudentSession(String token, String deviceId, InstructorVO instructorVO);
}
