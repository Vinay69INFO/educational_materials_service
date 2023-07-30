package com.educational.material.vos;

import java.util.List;

import com.educational.material.vo.SubTopicVO;
import com.educational.material.vo.TopicVO;

public class TopicVOs {
	private List<TopicVO> topicVO;
	//private List<SubTopicVO> subTopicVOs;

	public List<TopicVO> getTopicVO() {
		return topicVO;
	}

	public void setTopicVO(List<TopicVO> topicVO) {
		this.topicVO = topicVO;
	}

	@Override
	public String toString() {
		return "TopicVOs [topicVO=" + topicVO + "]";
	}
	
	
}
