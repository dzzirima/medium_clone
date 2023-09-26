package com.suprememedia.funda.comment.model;

import com.suprememedia.funda.article.model.Article;
import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.topic.model.Topic;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
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
    private Long id;
    private String content;
    private int claps;


    @ManyToOne
    @JoinColumn(
            name = "author",
            referencedColumnName = "id"
    )
    private UserProfile author;

    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JoinColumn(
            name = "article_id",
            referencedColumnName = "id"
    )
    private Article article;

    @OneToMany(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "comments",
            referencedColumnName = "id"
    )
    private List<Comment> comments;

    @OneToMany
    @JoinColumn(
            name = "topicList",
            referencedColumnName = "id"
    )
    private List<Topic> topicList;

}
