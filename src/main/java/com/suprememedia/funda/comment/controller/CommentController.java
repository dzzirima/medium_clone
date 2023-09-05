package com.suprememedia.funda.comment.controller;


import com.suprememedia.funda.comment.dto.UpdateCommentDto;
import com.suprememedia.funda.comment.model.Comment;
import com.suprememedia.funda.comment.service.CommentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private  final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment saveComment(
            Comment comment
    ){
        return  commentService.saveComment(comment);

    }
    public Comment getCommentById(
            Long commentId
    ){
        return  commentService.findCommentById(commentId);

    }

    public String updateComment(
            UpdateCommentDto updateCommentDto
    ){
        return commentService.updateComment(updateCommentDto);
    }

    public String deleteComment(
            Long commentId
    ){
        return  commentService.deleteCommentById(commentId);
    }








}
