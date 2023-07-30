package com.educational.material.transactions.interfaces;

import java.util.List;

import com.educational.material.vo.BlogVO;

public interface BlogTransaction {
	public List<BlogVO> getAllBlogVOByStatus(String status);
	
	public void createSubTopic(BlogVO blogVO);
	
	public BlogVO getBlogVObyBlogId(Integer blogId);
	
	public BlogVO getBlogVObyPageKey(String blogPageKey);

	public void deleteBlogById(Integer blogId);
}
