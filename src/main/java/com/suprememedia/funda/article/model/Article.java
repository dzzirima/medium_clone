package com.suprememedia.funda.article.model;

import com.suprememedia.funda.auth.model.UserProfile;
import jakarta.persistence.*;

import java.util.Date;


@Entity
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
    Double Id;

    @JoinColumn(name = "author",referencedColumnName = "Id")
    @ManyToOne
   private UserProfile author;
    private String content;
   private String tags; // use # to separate them

    private int claps;

    private String comments;

    private Date published;

    private double readTime;

}
