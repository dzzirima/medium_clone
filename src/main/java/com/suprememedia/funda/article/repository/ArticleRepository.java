package com.suprememedia.funda.article.repository;

import com.suprememedia.funda.article.model.Article;
import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.topic.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article ,Long> {
    List<Article> findArticleByTopic(Topic topic);
    List<Article> findArticleByAuthor(UserProfile author);
}
