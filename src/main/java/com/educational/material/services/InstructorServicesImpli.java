package com.educational.material.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educational.material.entity.InstructorEntity;
import com.educational.material.repository.InstructorRepo;
import com.educational.material.services.interfaces.InstructorService;
import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.LogedInUserVO;

@Service
public class InstructorServicesImpli implements InstructorService{

	@Autowired private InstructorRepo instructorRepo;
	
	@Override
	public InstructorVO getById(Long instructorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public LogedInUserVO getByLoninId(Long instructorId) {
		return getLogedInUserVO(instructorRepo.getById(instructorId));
	}
	
	private LogedInUserVO getLogedInUserVO(InstructorEntity entity) {
		LogedInUserVO userVO = new LogedInUserVO();
		userVO.setInstructorId(entity.getInstructorId());
		userVO.setEmailAddress(entity.getEmailAddress());
		userVO.setInstructorFullName(entity.getInstructorFullName());
		userVO.setInstructorPageKey(entity.getInstructorPageKey());
		return userVO;
	}
	

}
