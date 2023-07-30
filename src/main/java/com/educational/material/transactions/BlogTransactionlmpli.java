package com.educational.material.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educational.material.services.interfaces.BlogService;
import com.educational.material.transactions.interfaces.BlogTransaction;
import com.educational.material.vo.BlogVO;

@Component
public class BlogTransactionlmpli implements BlogTransaction{
	
	@Autowired private BlogService blogService;

	@Override
	public List<BlogVO> getAllBlogVOByStatus(String status) {
		List<BlogVO> blogVOs = blogService.getAllBlogVOByStatus(status);
		return blogVOs;
	}

	@Override
	public void createSubTopic(BlogVO blogVO) {
		blogService.createBlog(blogVO);
		
	}

	@Override
	public BlogVO getBlogVObyBlogId(Integer blogId) {
		
		return blogService.getBlogVObyBlogId(blogId);
	}

	@Override
	public BlogVO getBlogVObyPageKey(String blogPageKey) {
		return blogService.getBlogVObyPageKey(blogPageKey);
	}

	@Override
	public void deleteBlogById(Integer blogId) {
		blogService.deleteBlogById(blogId);
	}
}
