package com.suprememedia.funda.comment.model;

import com.suprememedia.funda.article.model.Article;
import com.suprememedia.funda.auth.model.UserProfile;
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

    @ManyToOne()
    @JoinColumn(
            name = "article_id",
            referencedColumnName = "id"
    )
    private Article article;

    @OneToMany
    @JoinColumn(
            name = "comments",
            referencedColumnName = "id"
    )
    private List<Comment> comments;

}
