package com.educational.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.educational.material.transactions.interfaces.SubTopicTransaction;
import com.educational.material.vo.NavigationVO;
import com.educational.material.vo.ResponseVO;
import com.educational.material.vo.SubTopicVO;
import com.educational.material.vo.TopicVO;

@RestController
public class SubTopicController {
	
	@Autowired private SubTopicTransaction subTopicTransaction;
	
	@GetMapping("/pulic/subtopic/{status}")
	public ResponseVO getAllTopicByStatus(@PathVariable("status") String status){
		ResponseVO responseVO = new ResponseVO();
		List<SubTopicVO> subTopicVOs = subTopicTransaction.getAllSubTopicVOByStatus(status);
		responseVO.setPayload(subTopicVOs);
		return responseVO;
	}
	
	@PostMapping("/add/subtopic")
	public ResponseVO createTopic(@RequestBody SubTopicVO subTopicVO) {
		ResponseVO responseVO = new ResponseVO();
		subTopicTransaction.createSubTopic(subTopicVO);
		responseVO.setPayload(subTopicVO);
		return responseVO;
	}
	
	@GetMapping("/public/get/subtopic")
	public ResponseVO getSubTopicByTitle(@PathVariable("title") String title){
		ResponseVO responseVO = new ResponseVO();
		SubTopicVO subTopicVO = subTopicTransaction.getSubTopicByTitle(title);
		return responseVO;
	}
	
	@DeleteMapping("/delete/subtopic/{subtopicId}")
	public ResponseVO deleteSubTopicByNavId(@PathVariable("subtopicId") Integer subtopicId) {
		ResponseVO responseVO = new ResponseVO();
		subTopicTransaction.deleteSubTopicByNavId(subtopicId);
		responseVO.setMes(subtopicId + "Deleted successuly!");
		return responseVO;
	}
	
	@PutMapping("/update/subtopic")
	public ResponseVO updateSubTopicByNavId(@RequestBody SubTopicVO subTopicVO) {
		ResponseVO responseVO = new ResponseVO();
		System.out.println("NavigationVO ===Updated Navigation link==========> " + subTopicVO);

		subTopicTransaction.updateSubTopicVO(subTopicVO);
		responseVO.setMes(subTopicVO + " Data updated successuly!");
		return responseVO;
	}

	
	@GetMapping("/public/all/subtopic/{topicId}")
	public ResponseVO getALLSubTopicByTopicId(@PathVariable("topicId") Long topicId) {
		ResponseVO responseVO = new ResponseVO();
		List<SubTopicVO> topicVOs = subTopicTransaction.getALLSubTopicByTopicId(topicId);
		responseVO.setPayload(topicVOs);
		return responseVO;
	}
	
}
