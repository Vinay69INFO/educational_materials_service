package com.educational.material.services.interfaces;

import java.util.List;

import com.educational.material.vo.TopicVO;
import com.educational.material.vos.TopicVOs;

public interface TopicService {
	
	public List<TopicVO> getAllTopic(String status);
	public void createTopic(TopicVO topicVO);
	
	public List<TopicVO> getNavigationLinkByNavId(Long navId);
	public void deleteTopicBytopicId(Integer topicId);
	public void updateTopicBytopicId(TopicVO topicVO);
	public List<TopicVO> getNavigationLinkByNavTitle(String navTitle);

}
