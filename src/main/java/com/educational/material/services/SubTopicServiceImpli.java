package com.educational.material.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educational.material.entity.BlogEntity;
import com.educational.material.entity.SubTopicEntity;
import com.educational.material.entity.TopicEntity;
import com.educational.material.repository.SubTopicRepo;
import com.educational.material.repository.TopicRepo;
import com.educational.material.services.interfaces.SubTopicService;
import com.educational.material.vo.BlogVO;
import com.educational.material.vo.SubTopicVO;
import com.educational.material.vo.TopicVO;

@Component
public class SubTopicServiceImpli implements SubTopicService {

	@Autowired
	private SubTopicRepo subTopicRepo;
	
	@Autowired private TopicRepo topicRepo;

	@Override
	public void createSubTopic(SubTopicVO subTopicVO) {
		SubTopicEntity subTopicEntity = getSubTopicEntity(subTopicVO);
		subTopicRepo.save(subTopicEntity);

	}

	private SubTopicEntity getSubTopicEntity(SubTopicVO subTopicVO) {
		TopicEntity topicEntity =  topicRepo.getTopicById(subTopicVO.getTopicId());
		SubTopicEntity subTopicEntity = new SubTopicEntity();
		subTopicEntity.setTopicEntity(topicEntity);
		subTopicEntity.setSubTopicTitle(subTopicVO.getSubTopicTitle());
		subTopicEntity.setSubTopicNavigationUrl(subTopicVO.getSubTopicNavigationUrl());
		subTopicEntity.setSubtopictatus("P");
		subTopicEntity.setCreatedBy(1l);
		subTopicEntity.setCreatedTimeStamp(LocalDateTime.now());

		return subTopicEntity;
	}

	@Override
	public List<SubTopicVO> getAllSubTopicVOByTopicId(Long topicId, String status) {
		List<SubTopicEntity> subTopicEntities = subTopicRepo.getAllSubTopicByTopicId(topicId, status);
		return getSubTopicVos(subTopicEntities);
	}
	
	@Override
	public List<SubTopicVO> getAllSubTopicVOByStatus(String status) {
		List<SubTopicEntity> subTopicEntities = subTopicRepo.getAllSubTopicByStatus( status);
		return getSubTopicVos(subTopicEntities);
	}

	
	private List<SubTopicVO> getSubTopicVos(List<SubTopicEntity> subTopicEntities) {
		List<SubTopicVO> subTopicVOs = subTopicEntities.stream().map(entity -> new SubTopicVO(entity.getSubTopicId(), entity.getTopicEntity().getTopicId(), entity.getSubTopicTitle(),
				entity.getSubTopicNavigationUrl(), entity.getSubtopictatus(), entity.getBlogPageKey(), entity.getCreatedBy(), entity.getCreatedTimeStamp(), entity.getLastUpdatedBy(), entity.getLastUpdatedTimeStamp())).collect(Collectors.toList());
		return subTopicVOs;
	}

	@Override
	public SubTopicVO getSubTopicByTitle(String title) {
		SubTopicEntity entity = subTopicRepo.getSubTopicByTitle(title);

		return null;
	}

	private SubTopicVO getSubTopicVO(SubTopicEntity subTopicEntity) {
	 SubTopicVO subTopicVO2 = new SubTopicVO();
	 subTopicVO2.setSubTopicTitle(subTopicEntity.getSubTopicTitle());
	/* subTopicVO2.();
	 subTopicVO2.setSubtopic_status(subTopicVO.getSubtopicStatus());
	 subTopicVO2.setCreated_timestamp(LocalD ateTime.now());*/
	 return subTopicVO2; 
	 
	}

	@Override
	public void deleteSubTopicByNavId(Integer subTopicId) {
		subTopicRepo.deleteById(subTopicId);

		
	}

	@Override
	public void updateSubTopicVOBytopicId(SubTopicVO subTopicVO) {
		int navId = subTopicRepo.updateSubTopicVOBytopicId(1, subTopicVO.getSubTopicID(), subTopicVO.getSubTopicTitle(), subTopicVO.getSubTopicNavigationUrl(), LocalDateTime.now());
		
	}

	@Override
	public List<SubTopicVO> getALLSubTopicByTopicId(Long topicId) {
		List<SubTopicEntity> topicEntity = subTopicRepo.getAllSubTopicByStatus(topicId);
		return getSubTopicVos(topicEntity);
	}
	

}
