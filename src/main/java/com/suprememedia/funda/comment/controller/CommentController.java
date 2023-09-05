package com.suprememedia.funda.comment.controller;


import com.suprememedia.funda.comment.dto.UpdateCommentDto;
import com.suprememedia.funda.comment.model.Comment;
import com.suprememedia.funda.comment.service.CommentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
            @RequestBody Comment comment
    ){
        return  commentService.saveComment(comment);

    }
    public Comment getCommentById(
            @RequestBody Long commentId
    ){
        return  commentService.findCommentById(commentId);

    }

    public String updateComment(
           @RequestBody UpdateCommentDto updateCommentDto
    ){
        return commentService.updateComment(updateCommentDto);
    }

    public String deleteComment(
           @RequestBody Long commentId
    ){
        return  commentService.deleteCommentById(commentId);
    }








}
