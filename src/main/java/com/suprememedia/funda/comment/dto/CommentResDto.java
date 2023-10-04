package com.suprememedia.funda.comment.dto;

public record CommentResDto(
        Long articleId,
        String content,
        int claps,

        Long commentId,

        Long authorId
) {
}
