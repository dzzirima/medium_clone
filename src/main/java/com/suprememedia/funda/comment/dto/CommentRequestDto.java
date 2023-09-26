package com.suprememedia.funda.comment.dto;

public record CommentRequestDto(
        Long articleId,
        String content,
        int claps,

        Long commentId,

        Long authorId

) {
}
