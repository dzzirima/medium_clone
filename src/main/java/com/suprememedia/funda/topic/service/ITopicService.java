package com.suprememedia.funda.topic.service;

import com.suprememedia.funda.topic.dto.TopicUpdateDto;
import com.suprememedia.funda.topic.model.Topic;

import java.util.List;

public interface ITopicService {
    Topic saveTopic(Topic topic);

    boolean ifTopicExistsById(Long topicId);

    Topic findTopicById(Long topicId);

    Topic upDateTopic (TopicUpdateDto topicUpdateDto);

    String deleteTopicById(Long topicId);

    List<Topic> findAllTopic();
}
