package com.educational.material.services.interfaces;

import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.InstructorVO;

public interface InstructorSessionServices {

	InstructorSessionVO userSessionByTokenAndDevicceId(String token, String deviceId);

	InstructorSessionVO createStudentSession(String token, String deviceId, InstructorVO instructorVO);
}
