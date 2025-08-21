package com.educational.material.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educational.material.entity.NavigationEntity;
import com.educational.material.entity.TopicEntity;
import com.educational.material.repository.NavigationLinkRepo;
import com.educational.material.repository.TopicRepo;
import com.educational.material.services.interfaces.TopicService;
import com.educational.material.vo.TopicVO;
import com.educational.material.vos.TopicVOs;

@Service
public class TopicServiceImpli implements TopicService{
	
	@Autowired private TopicRepo topicRepo;
	
	@Autowired private NavigationLinkRepo navigationLinkRepo;

	@Override
	public List<TopicVO> getAllTopic(String status) {
		List<TopicEntity> entities =  topicRepo.getAllNavItemByStatus(status);
		return getTopicVOs(entities);
	}

	private List<TopicVO> getTopicVOs(List<TopicEntity> entities) {
		List<TopicVO> topicVOs = entities.stream().map(entity -> new TopicVO(entity.getTopicId(), entity.getTopicTitle(), entity.getTopicNavigationUrl(), entity.getTopicStatus(), 
				entity.getAddSubTopicStatus(),entity.getBlogPageKey(), entity.getCreatedBy(), entity.getCreatedTimeStamp(), entity.getLastUpdatedBy(), entity.getLastUpdatedTimeStamp()))
				.collect(Collectors.toList());
		return topicVOs;
	}

	@Override
	public TopicVO createTopic(TopicVO topicVO) {
		TopicEntity topicEntity = getTopicEntity(topicVO);
		return getTopicVO(topicRepo.save(topicEntity));
	}

	private TopicEntity getTopicEntity(TopicVO topicVO) {
		NavigationEntity navigationEntity = navigationLinkRepo.getById(topicVO.getNavId());
		System.out.println("hellow ji" + navigationEntity);
		TopicEntity entity = new TopicEntity();
		entity.setTopicTitle(topicVO.getTopicTitle());
		//entity.setNavigationEntity(navigationEntity.isPresent() ? navigationEntity.get() : null); // Conditional or Ternary operation
		entity.setNavigationEntity(navigationEntity); // Conditional or Ternary operation
		entity.setTopicNavigationUrl(topicVO.getTopicNavigationUrl());
		entity.setTopicStatus("P");
		entity.setAddSubTopicStatus(topicVO.getSubTopicStatus());
		entity.setCreatedBy(1l);
		entity.setCreatedTimeStamp(LocalDateTime.now());

		return entity;
	}

	@Override
	public List<TopicVO> getNavigationLinkByNavId(Long navId) {
		
		List<TopicEntity> topicEntity = topicRepo.getNavigationLinkByNavId(navId);
		return getTopicVOs(topicEntity);
	}
	
	@Override
	public List<TopicVO> getNavigationLinkByNavTitle(String navTitle) {
		NavigationEntity navigationEntity = navigationLinkRepo.getNavigationEntityByTtile(navTitle);
		System.out.println(navTitle + " ==== navigationEntity ======dddddddddd==================> " + navigationEntity);
		List<TopicEntity> topicEntity = topicRepo.getNavigationLinkByNavId(navigationEntity.getNavId());
		return getTopicVOs(topicEntity);
	}

	private TopicVO getTopicVO(TopicEntity topicEntity) {
		TopicVO topicVO = new TopicVO();
		topicVO.setTopicId(topicEntity.getTopicId());
		topicVO.setTopicTitle(topicEntity.getTopicTitle());
		topicVO.setTopicNavigationUrl(topicEntity.getTopicNavigationUrl());
		topicVO.setTopicStatus(topicEntity.getTopicStatus());
		return topicVO;
	}

	@Override
	public void deleteTopicBytopicId(Integer topicId) {
		topicRepo.deleteById(topicId);
		
	}

	@Override
	public void updateTopicBytopicId(TopicVO topicVO) {
		int navId = topicRepo.updateTopicVO(1, topicVO.getTopicId(), topicVO.getTopicTitle(), topicVO.getTopicNavigationUrl(), LocalDateTime.now());
		
	}
	

}
