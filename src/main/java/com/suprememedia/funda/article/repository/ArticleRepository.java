package com.suprememedia.funda.article.repository;

import com.suprememedia.funda.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article ,Long> {
}
