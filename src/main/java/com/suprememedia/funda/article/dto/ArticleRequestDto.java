package com.suprememedia.funda.article.dto;

import java.util.Date;

public record ArticleRequestDto(
        Long topicId,
        String content,
        int claps,
        Date published

) {
}
