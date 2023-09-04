package com.suprememedia.funda.comment.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.util.List;

public class Comment {
    @Id
    @SequenceGenerator(
            sequenceName = "comment_sequence"
            ,name = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "comment_sequence",
            strategy = GenerationType.SEQUENCE
    )
    Double Id;
    String content;
    int claps;
    List<Comment> comments;

}
