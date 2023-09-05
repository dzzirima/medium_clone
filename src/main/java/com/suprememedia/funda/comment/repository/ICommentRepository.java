package com.suprememedia.funda.comment.repository;

import com.suprememedia.funda.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment , Long> {
}
