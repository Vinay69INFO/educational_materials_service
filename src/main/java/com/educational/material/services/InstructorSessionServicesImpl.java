package com.educational.material.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educational.material.entity.InstructorSessionEntity;
import com.educational.material.entity.pk.InstructorSessionPK;
import com.educational.material.repository.InstructorSessionRepo;
import com.educational.material.services.interfaces.InstructorSessionServices;
import com.educational.material.vo.auth.InstructorSessionVO;
import com.educational.material.vo.auth.InstructorVO;

@Service
public class InstructorSessionServicesImpl implements InstructorSessionServices{

	@Autowired private InstructorSessionRepo instructorSessionRepo;
	
	@Override
	public InstructorSessionVO userSessionByTokenAndDevicceId(String token, String deviceId) {
		System.out.println(deviceId + " <=========================> " + token);
		InstructorSessionEntity entity = instructorSessionRepo.getByTokenAndDevideId(token, deviceId);
		System.out.println(deviceId + " <========= entity ================> " + entity);
		return getVO(entity);
	}

	public InstructorSessionVO getVO(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null ) return null;
		InstructorSessionEntity  entity = (InstructorSessionEntity) obj;
        InstructorSessionVO vo = new InstructorSessionVO();
        
        vo.setLoginId(entity.getInstructorEntity().getInstructorId());
        vo.setDeviceId(entity.getInstructorSessionPK().getDeviceId());
        vo.setSessionToken(entity.getSessionToken());
        vo.setLoginDateTime((LocalDateTime) entity.getLoginTimestamp());
        vo.setLoginClassification(entity.getLoginClassification());
        vo.setLogoutOrInvalidationDateTime((LocalDateTime) entity.getLogoutOrInvalidationDateTime());
        vo.setStatus(entity.getStatus());
        return  vo;
	}
	
	@Override
	public InstructorSessionVO createStudentSession(String token, String deviceId, InstructorVO instructorVO) {
		InstructorSessionEntity entity = new InstructorSessionEntity();
		InstructorSessionPK pk = new InstructorSessionPK();
		pk.setDeviceId(UUID.randomUUID().toString());
		System.out.println("===== instructorVO.getInstructorId() =========================> " + instructorVO.getInstructorId());
		pk.setInstructorId(instructorVO.getInstructorId());
		entity.setInstructorSessionPK(pk);
		entity.setSessionToken(token);
		entity.setLoginClassification("I");  // I-> Instructor
		//instructorSessionRepo.save(entity);
		return getInstructorSessionVO(instructorSessionRepo.save(entity));
	}
	
	private InstructorSessionVO getInstructorSessionVO(InstructorSessionEntity entity) {
		InstructorSessionVO sessionVO = new InstructorSessionVO();
		sessionVO.setDeviceId(entity.getInstructorSessionPK().getDeviceId());
		sessionVO.setLoginId(entity.getInstructorSessionPK().getInstructorId());
		sessionVO.setLoginClassification(entity.getLoginClassification());
		sessionVO.setSessionToken(entity.getSessionToken());
		return sessionVO;
	}
	
}
