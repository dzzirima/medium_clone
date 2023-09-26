package com.suprememedia.funda.topic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Topic {

    @Id
    @SequenceGenerator(
            sequenceName = "topic_sequence"
            ,name = "topic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "topic_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
   private String topicName;


}
