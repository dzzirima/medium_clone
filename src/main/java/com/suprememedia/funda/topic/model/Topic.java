package com.suprememedia.funda.topic.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
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
    Double Id;
    String topicName;

}
