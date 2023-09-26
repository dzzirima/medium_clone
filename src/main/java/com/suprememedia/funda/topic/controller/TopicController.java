package com.suprememedia.funda.topic.controller;

import com.suprememedia.funda.topic.dto.TopicRequestDto;
import com.suprememedia.funda.topic.dto.TopicUpdateDto;
import com.suprememedia.funda.topic.model.Topic;
import com.suprememedia.funda.topic.service.TopicServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/topic")
public class TopicController {
    private  final TopicServiceImpl topicService;

    public TopicController(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }
    // controller to add new  topic to the system
    @PostMapping
    Topic saveTopic(
          @RequestBody TopicRequestDto topicRequestDto
    ){

        // create a new topic and populate it with dto things that would have been passed
        // this allows us to create unique id for example and add other initialisations
        Topic createdTopic = new Topic();

        //populating it contents //TODO replace with mapper
        createdTopic.setTopicName(topicRequestDto.topicName());

        // pass and save it
        return topicService.saveTopic(createdTopic);
    }

    @GetMapping
    Topic getTopic(
         @RequestBody   Long topicId
    ){
        return  topicService.findTopicById(topicId);
    }

    @PutMapping
    Topic updateTopic(
            @RequestBody TopicUpdateDto topicUpdateDto
            ){
        return  topicService.upDateTopic(topicUpdateDto);
    }

    @DeleteMapping
    String deleteTopicById(
            @RequestBody Long topicId
    ){
        return  topicService.deleteTopicById(topicId);
    }


    @GetMapping("/all")
    List<Topic> findAllTopics (){
        return  topicService.findAllTopic();
    }
}
