package com.educational.material.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educational.material.entity.BlogEntity;
import com.educational.material.repository.BlogRepo;
import com.educational.material.repository.SubTopicRepo;
import com.educational.material.repository.TopicRepo;
import com.educational.material.services.interfaces.BlogService;
import com.educational.material.vo.BlogVO;
import com.educational.material.vo.TopicVO;

@Service
public class BlogServiceImpli implements BlogService {

	@Autowired private BlogRepo blogRepo;
	
	@Autowired private TopicRepo topicRepo;
	
	@Autowired private SubTopicRepo subTopicRepo;

	
	@Override
	public void createBlog(BlogVO blogVO) {
		BlogEntity blogEntity = getBlogEntity(blogVO);
		BlogEntity blogEntity1 = blogRepo.save(blogEntity);
		if (blogEntity1 != null) {
			String blogPageKey = blogEntity1.getBlogTitle().toLowerCase()+"-"+blogEntity1.getBlogId();
			int blogEntity2 = blogRepo.updateBlogVO(blogPageKey, 1l, LocalDateTime.now(), blogEntity1.getBlogId());
			if(blogEntity2 != 0 && blogEntity1.getSubTopicEntity() != null ) {
				subTopicRepo.updateSubTopicVO(blogPageKey, 1l, LocalDateTime.now(), blogEntity1.getSubTopicEntity().getSubTopicId());
			} else if (blogEntity1 != null && blogEntity1.getTopicEntity() != null) {
				topicRepo.updateTopicVO(blogPageKey, 1l, LocalDateTime.now(), blogEntity1.getTopicEntity().getTopicId());
			} else {
				System.out.println("==========================Having Some Issue Regarding ============================> " + blogEntity2);
			}
		}
	}

	private BlogEntity getBlogEntity(BlogVO blogVO) {
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setBlogTitle(blogVO.getBlogTitle());
		blogEntity.setBlogBody(blogVO.getBlogBody());
		blogEntity.setBlogStatus("P");
		blogEntity.setTopicEntity(blogVO.getTopicId() != null? topicRepo.getTopicById(blogVO.getTopicId()) : null );
		blogEntity.setSubTopicEntity(blogVO.getTopicId() != null? subTopicRepo.getSubTopicById(blogVO.getSubTopicId()) : null );
		blogEntity.setCreatedBy(1l);
		blogEntity.setCreatedTimeStamp(LocalDateTime.now());
		return blogEntity;
	}

	@Override
	public List<BlogVO> getAllBlogVOByStatus(String status) {
		List<BlogEntity> blogEntities = blogRepo.getAllBlogByStatus(status);
		return getListOfBlogVO(blogEntities);
	}

	private List<BlogVO> getListBlogVos(List<BlogEntity> blogEntities) {
		List<BlogVO> blogVOs = blogEntities.stream()
				.map(entity -> 
					new BlogVO(entity.getBlogId(), entity.getBlogTitle(), entity.getBlogBody(), entity.getBlogPageKey(),
							entity.getBlogStatus(), entity.getCreatedBy(), entity.getCreatedTimeStamp(), 
							entity.getLastUpdatedBy(), entity.getLastUpdatedTimeStamp())).collect(Collectors.toList());
		return blogVOs;
	}
	
	private List<BlogVO> getListOfBlogVO(List<BlogEntity> blogEntities) {
		List<BlogVO> blogVOs = blogEntities.stream()
				.map(entity -> 
					new BlogVO(entity.getBlogId(), entity.getBlogTitle(), entity.getBlogBody(), entity.getBlogPageKey(),
							entity.getBlogStatus(), entity.getNavigationEntity().getNavId(), entity.getNavigationEntity().getNavTitle(), 
							entity.getTopicEntity() != null ? entity.getTopicEntity().getTopicId() : 0L,
							entity.getTopicEntity() != null ? entity.getTopicEntity().getTopicTitle() : "NA",
							entity.getSubTopicEntity() != null ? entity.getSubTopicEntity().getSubTopicId(): 0L, 
							entity.getSubTopicEntity() != null ? entity.getSubTopicEntity().getSubTopicTitle(): "NA",
							entity.getLastUpdatedBy()!= null ? entity.getLastUpdatedBy()  : 0L, entity.getLastUpdatedTimeStamp())).collect(Collectors.toList());
		return blogVOs;
	}

	@Override
	public BlogVO getBlogVObyBlogId(Long blogId) {
		BlogEntity blogEntity = blogRepo.getById(blogId);
		return getBlogVO(blogEntity);
	}
	
	private BlogVO getBlogVO(BlogEntity blogEntity) {
		BlogVO blogVO = new BlogVO();
		System.out.println("blogEntity ==========================> " + blogEntity);
		blogVO.setBlogTitle(blogEntity.getBlogTitle());
		blogVO.setBlogBody(blogEntity.getBlogBody());
		blogVO.setCreatedBy(blogEntity.getCreatedBy());
		blogVO.setCreatedTimeStamp(blogEntity.getCreatedTimeStamp());
		/*
		 * blogVO.setLastUpdatedBy(blogEntity.getLastUpdatedBy() == null? "" :
		 * blogEntity.getLastUpdatedBy());
		 * blogVO.setLastUpdatedTimeStamp(blogEntity.getLastUpdatedTimeStamp());
		 */
		return blogVO;
	}

	@Override
	public BlogVO getBlogVObyPageKey(String blogPageKey) {
		BlogEntity blogEntity = blogRepo.getBlogByPagekey(blogPageKey);
		return getBlogVO(blogEntity);
	}

	@Override
	public void deleteBlogById(Long blogId) {
		blogRepo.deleteById(blogId);
	}

}
