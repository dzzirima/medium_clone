package com.suprememedia.funda.comment.controller;


import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.comment.dto.CommentRequestDto;
import com.suprememedia.funda.comment.dto.CommentResDto;
import com.suprememedia.funda.comment.dto.UpdateCommentDto;
import com.suprememedia.funda.comment.model.Comment;
import com.suprememedia.funda.comment.service.CommentServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
            @RequestBody CommentRequestDto commentRequestDto
            ){
        return  commentService.saveComment(commentRequestDto);

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

    @GetMapping("/allq")
    public List<Comment> getAllComments(
    ){
        return  commentService.findAll();
    }
    @GetMapping("/all")
    public List<CommentResDto> getCommentsByArticle(
            @RequestParam Long articleId
    ){
        List<Comment> commentsByArticleId = commentService.findCommentsByArticleId(articleId);

        List<CommentResDto>  commentResDtos = commentsByArticleId.stream().map(comment -> {
            UserProfile author = comment.getAuthor();
            return new CommentResDto(
                    comment.getArticle().getId(),
                    comment.getContent(),
                    comment.getClaps(),
                    comment.getId(),
                    comment.getAuthor().getId()


            );
        }).toList();
        System.out.println("commentsByArticleId.stream().count() = " + commentsByArticleId.stream().count());
        return commentResDtos;
    }


}
