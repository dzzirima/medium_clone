package com.suprememedia.funda.comment.service;

import com.suprememedia.funda.comment.dto.UpdateCommentDto;
import com.suprememedia.funda.comment.model.Comment;

import java.util.List;

public interface ICommentService {
    Comment saveComment(Comment comment);

    Comment findCommentById(Long commentId);

    String updateComment(UpdateCommentDto updateCommentDto);

    String deleteCommentById( Long commentId);

    List<Comment> findAll();
}
