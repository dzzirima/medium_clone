package com.suprememedia.funda.article.dto;

import java.util.Date;

public record ArticleRequestDto(
        String content,
        int claps,
        Date published

) {
}
