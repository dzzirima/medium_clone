package com.suprememedia.funda.comment.service;

import com.suprememedia.funda.article.model.Article;
import com.suprememedia.funda.comment.dto.UpdateCommentDto;
import com.suprememedia.funda.comment.model.Comment;
import com.suprememedia.funda.comment.repository.ICommentRepository;
import com.suprememedia.funda.utils.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements ICommentService{
    private final ICommentRepository commentRepository;

    public CommentServiceImpl(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment findCommentById(Long commentId) {
        return  commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Article with id [ %s ]".formatted(commentId))
                );
    }

    @Override
    public String updateComment(UpdateCommentDto updateCommentDto) {
        Comment foundComment= findCommentById(updateCommentDto.id());
        boolean changes = false;

        if(!foundComment.getContent().equals(updateCommentDto.content())){
            foundComment.setContent(updateCommentDto.content());
            changes = true;
        }

        if(changes){
            commentRepository.save(foundComment);
            return " Comment updated successfully ";
        }

        return "No comment record was updated." ;
    }

    @Override
    public String deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
        return "Comment successfully deleted";
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
