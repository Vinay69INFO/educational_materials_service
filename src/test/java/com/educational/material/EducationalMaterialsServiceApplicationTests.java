package com.educational.material;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.educational.material.controller.TopicController;
import com.educational.material.transactions.interfaces.TopicTransaction;
import com.educational.material.vo.ResponseVO;
import com.educational.material.vo.TopicVO;

import io.swagger.models.Response;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EducationalMaterialsServiceApplicationTests {

	@InjectMocks private TopicController topicController;
	
	@Mock private TopicTransaction topicTransaction;
	
	private List<TopicVO> sampleTopicVOs = new ArrayList<>();
	
	private TopicVO sampleTopicVO;
	
	@BeforeEach
	void setUp() {
	    sampleTopicVO = new TopicVO();
		sampleTopicVO.setTopicId(1001l);
		sampleTopicVO.setNavId(1001);
		sampleTopicVO.setTopicTitle("Spring Boot");
		sampleTopicVO.setTopicNavigationUrl("/contents/overview");
		sampleTopicVO.setSubTopicStatus("P");
		sampleTopicVO.setBlogPageKey("SpringBoot1001");
		sampleTopicVO.setCreatedBy(1009l);
		sampleTopicVO.setCreatedTimeStamp(LocalDateTime.parse("2025-07-03T10:30:00"));
		sampleTopicVO.setLastUpdatedBy(1009l);
		sampleTopicVO.setLastUpdatedTimeStamp(LocalDateTime.parse("2025-07-03T10:30:00"));
	}
		
	@Test
	void testCreateUser() {
		Mockito.when(topicTransaction.createTopic(Mockito.any(TopicVO.class))).thenReturn(sampleTopicVO);

		ResponseEntity response = topicController.createTopic(sampleTopicVO);
		
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode() );
		//Assertions.assertEquals(201, response.getAppStatusCode());
		
		
		Assertions.assertEquals(1001L, (long) ((TopicVO) response.getBody()).getNavId());
	}
	
	
	@BeforeEach
	void setUpTopicVOs() {
		TopicVO sampleTopicVO = new TopicVO();
		sampleTopicVO.setTopicId(1001l);
		sampleTopicVO.setNavId(1001);
		sampleTopicVO.setTopicTitle("Spring Boot");
		sampleTopicVO.setTopicNavigationUrl("/contents/overview");
		sampleTopicVO.setSubTopicStatus("P");
		sampleTopicVO.setBlogPageKey("SpringBoot1001");
		sampleTopicVO.setCreatedBy(1009l);
		sampleTopicVO.setCreatedTimeStamp(LocalDateTime.parse("2025-07-03T10:30:00"));
		sampleTopicVO.setLastUpdatedBy(1009l);
		sampleTopicVO.setLastUpdatedTimeStamp(LocalDateTime.parse("2025-07-03T10:30:00"));
		this.sampleTopicVOs.add(sampleTopicVO);
		
		TopicVO sampleTopicVO1 = new TopicVO();
		sampleTopicVO1.setTopicId(1002l);
		sampleTopicVO1.setNavId(1001);
		sampleTopicVO1.setTopicTitle("Spring Boot");
		sampleTopicVO1.setTopicNavigationUrl("/contents/overview");
		sampleTopicVO1.setSubTopicStatus("P");
		sampleTopicVO1.setBlogPageKey("SpringBoot1001");
		sampleTopicVO1.setCreatedBy(1009l);
		sampleTopicVO1.setCreatedTimeStamp(LocalDateTime.parse("2025-07-03T10:30:00"));
		sampleTopicVO1.setLastUpdatedBy(1009l);
		sampleTopicVO1.setLastUpdatedTimeStamp(LocalDateTime.parse("2025-07-03T10:30:00"));
	
		this.sampleTopicVOs.add(sampleTopicVO1);
	}
	
	
	@Test
	void testGetUserById() {
		Mockito.when(topicTransaction.getALLTopicWithSubTopicByNav(1001l)).thenReturn(sampleTopicVOs);
		
		ResponseEntity<TopicVO> response = topicController.getALLTopicByNavId(1001l);
		
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode()); 
		//Assertions.assertEquals("Overview", response.getBody());
	}
}
