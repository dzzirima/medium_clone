package com.suprememedia.funda.comment.dto;

public record UpdateCommentDto(
        Long id,
        String content ,
        int claps
) {
}
