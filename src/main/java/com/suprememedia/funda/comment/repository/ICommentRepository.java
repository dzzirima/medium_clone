package com.suprememedia.funda.comment.repository;

import com.suprememedia.funda.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment , Long> {

    List<Comment> findCommentsByArticle_Id(Long articleId);
}
