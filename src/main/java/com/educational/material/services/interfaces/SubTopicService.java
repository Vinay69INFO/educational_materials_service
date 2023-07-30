package com.educational.material.services.interfaces;

import java.util.List;

import com.educational.material.vo.BlogVO;
import com.educational.material.vo.SubTopicVO;
import com.educational.material.vo.TopicVO;
public interface SubTopicService {
	public void createSubTopic(SubTopicVO subTopicVO);
	
	public List<SubTopicVO> getAllSubTopicVOByTopicId(Long topicId, String status);
	
	public List<SubTopicVO> getAllSubTopicVOByStatus(String status);
	
	public SubTopicVO getSubTopicByTitle(String title);

	public void deleteSubTopicByNavId(Integer topicId);

	public void updateSubTopicVOBytopicId(SubTopicVO subTopicVO);

	public List<SubTopicVO> getALLSubTopicByTopicId(Long topicId);


}
