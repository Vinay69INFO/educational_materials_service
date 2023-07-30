package com.educational.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educational.material.transactions.interfaces.TopicTransaction;
import com.educational.material.vo.NavigationVO;
import com.educational.material.vo.ResponseVO;
import com.educational.material.vo.TopicVO;
import com.educational.material.vos.TopicVOs;

@RestController
//@RequestMapping("/public")
@RequestMapping("/admin")
public class TopicController {
	
	@Autowired TopicTransaction topicTransaction;

	@GetMapping("/topic/{status}")
	public ResponseVO getAllTopicByStatus(@PathVariable("status") String status){
		ResponseVO responseVO = new ResponseVO();
		List<TopicVO> topicVOs = topicTransaction.getAllTopicsByStatus(status);
		responseVO.setPayload(topicVOs);
		return responseVO;
	}
	
	@PostMapping("/add/topic")
	public ResponseVO createTopic(@RequestBody TopicVO topicVO) {
		System.out.println("hellow ===========> " + topicVO);
		ResponseVO responseVO = new ResponseVO();
		topicTransaction.createTopic(topicVO);
		responseVO.setPayload(topicVO);
		return responseVO;
	}
	
	@GetMapping("/all/topics/{navid}")
	public ResponseVO getALLTopicByNavId(@PathVariable("navid") Long navId) {
		ResponseVO responseVO = new ResponseVO();
		List<TopicVO> topicVOs = topicTransaction.getALLTopicWithSubTopicByNav(navId);
		responseVO.setPayload(topicVOs);
		return responseVO;
	}
	
	@GetMapping("/get/all/topics/{navtitle}")
	public ResponseVO getALLTopicByNavId(@PathVariable("navtitle") String navtitle) {
		ResponseVO responseVO = new ResponseVO();
		List<TopicVO> topicVOs = topicTransaction.getALLTopicWithSubTopicByNavTile(navtitle);
		responseVO.setPayload(topicVOs);
		return responseVO;
	}
	
	@DeleteMapping("/delete/topic/{topicId}")
	public ResponseVO deleteTopicBytopicId(@PathVariable("topicId") Integer topicId) {
		ResponseVO responseVO = new ResponseVO();
		topicTransaction.deleteTopicBytopicId(topicId);
		responseVO.setMes(topicId + "Deleted successuly!");
		return responseVO;
	}
	
	@PutMapping("/update/topic")
	public ResponseVO updateTopicBytopicId(@RequestBody TopicVO topicVO) {
		ResponseVO responseVO = new ResponseVO();
		System.out.println("topicVO ===Updated Topic link==========> " + topicVO);
		topicTransaction.updateTopicBytopicId(topicVO);
		responseVO.setMes(topicVO + " Data updated successuly!");
		return responseVO;
	}
	
}
