package com.educational.material.transactions.interfaces;

import java.util.List;

import com.educational.material.vo.BlogVO;
import com.educational.material.vo.SubTopicVO;
import com.educational.material.vo.TopicVO;

public interface SubTopicTransaction {

	public List<SubTopicVO> getAllSubTopicVOByStatus(String status);
	
	public void createSubTopic(SubTopicVO subTopicVO);
	
	public SubTopicVO getSubTopicByTitle(String title);

	public void deleteSubTopicByNavId(Integer subtopicId);

	public void updateSubTopicVO(SubTopicVO subTopicVO);

	public List<SubTopicVO> getALLSubTopicByTopicId(Long topicId);
}
