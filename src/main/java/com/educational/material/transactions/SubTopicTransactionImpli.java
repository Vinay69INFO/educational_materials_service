package com.educational.material.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educational.material.services.interfaces.SubTopicService;
import com.educational.material.transactions.interfaces.SubTopicTransaction;
import com.educational.material.vo.BlogVO;
import com.educational.material.vo.SubTopicVO;
import com.educational.material.vo.TopicVO;

@Component
public class SubTopicTransactionImpli implements SubTopicTransaction{
	
	@Autowired private SubTopicService subTopicService;

	@Override
	public List<SubTopicVO> getAllSubTopicVOByStatus(String status) {
		List<SubTopicVO> subTopicVOs = subTopicService.getAllSubTopicVOByStatus(status);
		return subTopicVOs;
	}

	@Override
	public void createSubTopic(SubTopicVO subTopicVO) {
		subTopicService.createSubTopic(subTopicVO);
	}

	@Override
	public SubTopicVO getSubTopicByTitle(String title) {
		
		return subTopicService.getSubTopicByTitle(title);
	}

	@Override
	public void deleteSubTopicByNavId(Integer subtopicId) {
		subTopicService.deleteSubTopicByNavId(subtopicId);
		
	}

	@Override
	public void updateSubTopicVO(SubTopicVO subTopicVO) {
		subTopicService.updateSubTopicVOBytopicId(subTopicVO);
		
	}

	@Override
	public List<SubTopicVO> getALLSubTopicByTopicId(Long topicId) {
		List<SubTopicVO> subTopicVOs = subTopicService.getALLSubTopicByTopicId(topicId);

		return subTopicVOs;
	}

}
