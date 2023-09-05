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
            @RequestBody Article article
            ){

        return  articleService.saveArticle(article);
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



}
