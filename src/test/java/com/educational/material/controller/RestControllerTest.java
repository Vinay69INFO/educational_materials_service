package com.educational.material.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.educational.material.transactions.interfaces.TopicTransaction;
import com.educational.material.vo.TopicVO;

@WebMvcTest(TopicController.class)
@ContextConfiguration(classes = {TopicTransaction.class})
public class RestControllerTest {
	
	@Autowired private MockMvc mockMvc;
	
	@MockBean private TopicTransaction topicTransaction;
	
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
	void testCreateTopic() throws Exception {
		Mockito.when(topicTransaction.createTopic(Mockito.any(TopicVO.class))).thenReturn(sampleTopicVO);

		//when(topicTransaction.createTopic(any(TopicVO.class))).thenReturn(sampleTopicVO);
		/*mockMvc.perform(post("/add/topic").contentType(MediaType.APPLICATION_JSON)
				.content(sampleTopicVO.toString()))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.navId").value(100l))
				.andExpect(MockMvcResultMatchers.jsonPath("$.blogPageKey").value("SpringBoot1001"));
					*/	
	}
	
	
	
}
