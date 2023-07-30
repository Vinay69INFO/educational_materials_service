package com.educational.material.transactions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educational.material.services.interfaces.NavigationLinkService;
import com.educational.material.services.interfaces.SubTopicService;
import com.educational.material.services.interfaces.TopicService;
import com.educational.material.transactions.interfaces.TopicTransaction;
import com.educational.material.vo.NavigationVO;
import com.educational.material.vo.SubTopicVO;
import com.educational.material.vo.TopicVO;
import com.educational.material.vos.TopicVOs;

@Component
public class TopicTransactionImpli implements TopicTransaction{
	
	@Autowired NavigationLinkService navigationLinkService;
	@Autowired TopicService topicService;
	@Autowired SubTopicService subTopicService;

	@Override
	public List<TopicVO> getAllTopicsByStatus(String status) {
		return topicService.getAllTopic(status);
	}

	@Override
	public void createTopic(TopicVO topicVO) {
		topicService.createTopic(topicVO);
		
	}

	@Override
	public List<TopicVO> getALLTopicWithSubTopicByNav(Long navId) {
		TopicVOs topicVOs = new TopicVOs();
		//NavigationVO navigationVO = navigationLinkService.getNavigationVOByTitle(title);
		List<TopicVO> topicList = topicService.getNavigationLinkByNavId(navId);
		for (TopicVO vo : topicList) {
			List<SubTopicVO> subTopicVOs = subTopicService.getAllSubTopicVOByTopicId(vo.getTopicId(), "P");
			System.out.println("subTopicVOs ====================> " + subTopicVOs);
			vo.setSubTopicVOs(subTopicVOs);
			System.out.println("vo =====>  " + vo);
		}
		topicVOs.setTopicVO(topicList);
		
		return topicList;
	}
	
	@Override
	public List<TopicVO> getALLTopicWithSubTopicByNavTile(String navTitle) {
		TopicVOs topicVOs = new TopicVOs();
		//NavigationVO navigationVO = navigationLinkService.getNavigationVOByTitle(title);
		List<TopicVO> topicList = topicService.getNavigationLinkByNavTitle(navTitle);
		for (TopicVO vo : topicList) {
			List<SubTopicVO> subTopicVOs = subTopicService.getAllSubTopicVOByTopicId(vo.getTopicId(), "P");
			System.out.println("subTopicVOs ====================> " + subTopicVOs);
			vo.setSubTopicVOs(subTopicVOs);
			System.out.println("vo =====>  " + vo);
		}
		topicVOs.setTopicVO(topicList);
		
		return topicList;
	}

	@Override
	public void deleteTopicBytopicId(Integer topicId) {
		topicService.deleteTopicBytopicId(topicId);
	
	}

	@Override
	public void updateTopicBytopicId(TopicVO topicVO) {
		topicService.updateTopicBytopicId(topicVO);
		
	}

}
