package com.educational.material.transactions.interfaces;

import java.util.List;

import com.educational.material.vo.TopicVO;
import com.educational.material.vos.TopicVOs;

public interface TopicTransaction {
	public List<TopicVO> getAllTopicsByStatus(String status);
	public void createTopic(TopicVO topicVO);
	
	public List<TopicVO> getALLTopicWithSubTopicByNav(Long navId);
	
	public List<TopicVO> getALLTopicWithSubTopicByNavTile(String navTitle);

	
	public void deleteTopicBytopicId(Integer topicId);
	
	public void updateTopicBytopicId(TopicVO topicVO);
	
	
}
