package com.educational.material.services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educational.material.entity.InstructorEntity;
import com.educational.material.repository.InstructorRepo;
import com.educational.material.services.interfaces.InstructorService;
import com.educational.material.vo.auth.InstructorVO;
import com.educational.material.vo.auth.LoggedInUserVO;
import com.educational.material.vo.auth.RegisterVO;

@Service
public class InstructorServicesImpli implements InstructorService{
	
	private static final Logger LOGGER = LogManager.getLogger(InstructorServicesImpli.class);

	@Autowired private InstructorRepo instructorRepo;
	
	@Override
	public InstructorVO getById(Long instructorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public LoggedInUserVO getByLoninId(Long instructorId) {
		InstructorEntity entity = instructorRepo.getByInstructorId(instructorId);
		System.out.println("InstructorEntity ====> =========> " + entity);
		return getLogedInUserVO(entity);
	}
	
	private LoggedInUserVO getLogedInUserVO(InstructorEntity entity) {
		System.out.println("LoggedInUserVO ======================> " + entity);
		LoggedInUserVO userVO = new LoggedInUserVO();
		userVO.setInstructorId(entity.getInstructorId());
		userVO.setEmailAddress(entity.getEmailAddress());
		userVO.setInstructorFullName(entity.getInstructorFullName());
		userVO.setInstructorPageKey(entity.getInstructorPageKey());
		return userVO;
	}

	@Override
	public void createInstructor(RegisterVO registerVO) {
		InstructorEntity entity = getInstructorEntity(registerVO);
		
		System.out.println(" instructorRepo ========> " + instructorRepo.getInstructorByEmail(entity.getEmailAddress()));
		
		if (instructorRepo.getInstructorByEmail(entity.getEmailAddress()) == null) {
			instructorRepo.save(entity);
			System.out.println("Instructor record has created successfully in DB..!!");
			LOGGER.info("Instructor record has created successfully in DB..!!");
		} else {
			System.out.println("The DB has a duplicate record for this " + entity.getEmailAddress() + " email, please try with different Email ID..!!");
			LOGGER.debug("The DB has a duplicate record for this " + entity.getEmailAddress() + " email, please try with different Email ID..!!");
		}
	}
	
	private InstructorEntity getInstructorEntity(RegisterVO registerVO) {
		InstructorEntity entity = new InstructorEntity();
		entity.setEmailAddress(registerVO.getEmailAddress());
		entity.setPasswordEncrypted(registerVO.getPasswordEncrypted());
		entity.setInstructorFullName(registerVO.getInstructorFullName());
		return entity;
	}

	@Override
	public InstructorVO getInstructorDetailsByEmail(String emailId) {
		InstructorEntity instructorEntity = instructorRepo.getInstructorEntityByEmail(emailId);
		System.out.println("instructorEntity: =============>>> " + instructorEntity);
		InstructorVO instructorVO = getInstructorVO(instructorEntity);
		return instructorVO;
	}
	
	private InstructorVO getInstructorVO(InstructorEntity entity) {
		InstructorVO userVO = new InstructorVO();
		userVO.setInstructorId(entity.getInstructorId());
		userVO.setInstructorFullName(entity.getInstructorFullName());
		userVO.setEmailAddress(entity.getEmailAddress());
		userVO.setPasswordEncrypted(entity.getPasswordEncrypted());
		userVO.setInstructorPageKey(entity.getInstructorPageKey());
		return userVO;
	}
	

}
