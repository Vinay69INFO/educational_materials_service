package com.educational.material.entity.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InstructorSessionPK implements Serializable {

	private static final long serialVersionUID = 4503086258221926992L;

	//@Column(name = "instructor_id", nullable = false)
	private Long instructorId;
	//@Column(name = "device_id", nullable = false, length = 128)
	private String deviceId;
	
	
	public Long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	@Override
	public String toString() {
		return "InstructorSessionPK [instructorId=" + instructorId + ", deviceId=" + deviceId + "]";
	}

}
