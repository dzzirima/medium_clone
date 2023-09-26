package com.suprememedia.funda.topic.repository;

import com.suprememedia.funda.topic.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicRepository extends JpaRepository<Topic, Long> {
}
