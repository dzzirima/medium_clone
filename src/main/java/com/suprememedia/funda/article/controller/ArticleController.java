package com.suprememedia.funda.article.controller;


import com.suprememedia.funda.article.dto.ArticleRequestDto;
import com.suprememedia.funda.article.model.Article;
import com.suprememedia.funda.article.service.ArticleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/v1/article")
public class ArticleController {

    private  final ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }
    @PostMapping
    public Article saveArticle(
            @RequestBody ArticleRequestDto articleRequestDto
            ){

        // create a new object here nd

        return  articleService.saveArticle(articleRequestDto);
    }
    @GetMapping
    public Article getArticleById(
           @RequestBody Long articleId
    ){
        return  articleService.findById(articleId);
    }

    @DeleteMapping
    public  String deletePostById(
            @RequestBody Long articleId
    ){
        return articleService.deleteArticleById(articleId);
    }

    @GetMapping("/all")
    List<Article> findAllArticles(){
        return  articleService.findAll();

    }
    @GetMapping("/all/{topicId}")
    List<Article> findArticleByTopicId(
           @PathVariable Long topicId

            ){
        return  articleService.findArticleByTopic(topicId);

    }
    List<Article> findArticleByAuthorId(
           @PathVariable Long authorId

            ){
        return  articleService.findArticleByAuthor(authorId);

    }







}
