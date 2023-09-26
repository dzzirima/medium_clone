package com.suprememedia.funda.topic.service;

import com.suprememedia.funda.topic.dto.TopicUpdateDto;
import com.suprememedia.funda.topic.model.Topic;
import com.suprememedia.funda.topic.repository.ITopicRepository;
import com.suprememedia.funda.utils.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicServiceImpl implements  ITopicService{

    private final ITopicRepository topicRepository;

    public TopicServiceImpl(ITopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public boolean ifTopicExistsById(Long topicId) {

        return topicRepository.existsById(topicId);
    }

    @Override
    public Topic findTopicById(Long topicId) {
       return topicRepository.findById(topicId).orElseThrow(
                () -> new ResourceNotFoundException("Topic with id [ %s ]  not found".formatted(topicId))
        );
    }

    @Override
    public Topic upDateTopic(TopicUpdateDto topicUpdateDto) {
        // check if the topic exists in the first place
        boolean changes = false ; // variable to track if there are any changes in the contents of the topic
        Topic foundTopic = findTopicById(topicUpdateDto.topicId());

            // get the topic we want to modify

             if(!foundTopic.getTopicName().equals(topicUpdateDto.topicName())){
                 changes = true;
                 foundTopic.setTopicName(topicUpdateDto.topicName());
             }

            if(changes){
               return saveTopic(foundTopic);
            }

        return  foundTopic;
    }

    @Override
    public String deleteTopicById(Long topicId) {
        // this will handle the topic if it does not exit
        Topic foundTopic = findTopicById(topicId);
        topicRepository.deleteById(topicId);
        return "Topic with id [ %s ] was successfully delete ";
    }

    @Override
    public List<Topic> findAllTopic() {
        return topicRepository.findAll();
    }
}
