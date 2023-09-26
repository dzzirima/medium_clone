package com.suprememedia.funda.article.service;

import com.suprememedia.funda.article.dto.ArticleUpdateDto;
import com.suprememedia.funda.article.model.Article;

import java.util.List;

public interface IArticleService {
    Article findById(Long id);
    Article saveArticle(Article article);
     boolean existsById(Long articleId);

    String updateArticle(ArticleUpdateDto articleRequestDto);

    String deleteArticleById(Long id);

    List<Article> findAll();
}
