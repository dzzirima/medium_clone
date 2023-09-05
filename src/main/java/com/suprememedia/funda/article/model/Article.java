package com.suprememedia.funda.article.model;

import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.topic.model.Topic;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Article {

    @Id
    @SequenceGenerator(
            sequenceName = "article_sequence"
            ,name = "article_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "article_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @ManyToOne(
            cascade = CascadeType.ALL ,
            optional = true
    )
    @JoinColumn(
            name = "author",
            referencedColumnName = "id"
    )
   private UserProfile author;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = true
    )
    @JoinColumn(
            name = "topic",
            referencedColumnName = "id"
    )
    private Topic topic;
    private String content;
    private String tags; // use # to separate them
    private int claps;
    private boolean isPublished;
    private Date publishedDate;
    private double readTime;

}
