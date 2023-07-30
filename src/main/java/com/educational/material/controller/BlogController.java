package com.educational.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educational.material.transactions.interfaces.BlogTransaction;
import com.educational.material.vo.BlogVO;
import com.educational.material.vo.ResponseVO;
import com.educational.material.vo.SubTopicVO;

@RestController
@CrossOrigin(origins = {"http://localhost:4201", "http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})

public class BlogController {
	
	@Autowired private BlogTransaction blogTransaction;
	
	@GetMapping("/get/all/blog/{status}")
	public ResponseVO getAllTopicByStatus(@PathVariable("status") String status){
		ResponseVO responseVO = new ResponseVO();
		List<BlogVO> blogVOs = blogTransaction.getAllBlogVOByStatus(status);
		responseVO.setPayload(blogVOs);
		return responseVO;
	}
	
	@PostMapping("/add/blog")
	public ResponseVO createTopic(@RequestBody BlogVO blogVO) {
		ResponseVO responseVO = new ResponseVO();
		System.out.println("blogVo===============> " + blogVO);
		blogTransaction.createSubTopic(blogVO);
		responseVO.setPayload(blogVO);
		return responseVO;
	}
	
	@GetMapping("/get/blog/{blogid}")
	public ResponseVO getBlogVObyBlogId(@PathVariable("blogid") Integer blogId){
		ResponseVO responseVO = new ResponseVO();
		BlogVO blogVOs = blogTransaction.getBlogVObyBlogId(blogId);
		responseVO.setPayload(blogVOs);
		return responseVO;
	}
	
	@GetMapping("/get/blog/select/{blogPageKey}")
	public ResponseVO getBlogVObypageKey(@PathVariable("blogPageKey") String blogPageKey){
		ResponseVO responseVO = new ResponseVO();
		System.out.println("============@GetMapping====================> " + blogPageKey);
		BlogVO blogVOs = blogTransaction.getBlogVObyPageKey(blogPageKey);
		responseVO.setPayload(blogVOs);
		return responseVO;
	}
	
	@DeleteMapping("/delete/blog/{blogId}")
	public ResponseVO deleteBlogById(@PathVariable("blogId") Integer blogId) {
		ResponseVO responseVO = new ResponseVO();
		blogTransaction.deleteBlogById(blogId);
		responseVO.setMes(blogId + "Deleted successuly!");
		return responseVO;
	}
}
