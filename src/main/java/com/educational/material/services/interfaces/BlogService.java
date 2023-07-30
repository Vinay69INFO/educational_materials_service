package com.educational.material.services.interfaces;

import java.util.List;

import com.educational.material.vo.BlogVO;

public interface BlogService {
	public void createBlog(BlogVO blogVO);
	
	public List<BlogVO> getAllBlogVOByStatus(String status);
	
	public BlogVO getBlogVObyBlogId(Integer blogId);
	
	public BlogVO getBlogVObyPageKey(String blogPageKey);
	
	public void deleteBlogById(Integer blogId);

}
