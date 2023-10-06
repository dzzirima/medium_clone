package com.suprememedia.funda.article.service;

import com.suprememedia.funda.article.dto.ArticleRequestDto;
import com.suprememedia.funda.article.dto.ArticleUpdateDto;
import com.suprememedia.funda.article.model.Article;
import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.topic.model.Topic;

import java.util.List;

public interface IArticleService {
    Article findById(Long id);
    Article saveArticle(ArticleRequestDto article);
     boolean existsById(Long articleId);

    String updateArticle(ArticleUpdateDto articleRequestDto);

    String deleteArticleById(Long id);

    List<Article> findAll();

    List<Article> findArticleByAuthor(Long authorId);
    List<Article> findArticleByTopic(Long  topicId);


}
